package com.catmit.blog.server.web.service;

import com.catmit.blog.server.web.dao.ArticleDAO;
import com.catmit.blog.server.web.dao.UserDAO;
import com.catmit.blog.server.web.exception.BusinessException;
import com.catmit.blog.server.web.model.po.ArticlePO;
import com.catmit.blog.server.web.model.vo.ApiResult;
import com.catmit.blog.server.web.model.vo.ArticleVO;
import com.catmit.blog.server.web.model.vo.Page;
import com.catmit.blog.server.web.exception.AppearException;
import com.catmit.blog.server.web.exception.ErrorCode;
import com.catmit.blog.server.web.model.vo.UserVO;
import com.catmit.blog.server.web.util.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class ArticleService {

    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    UserDAO userDAO;


    public ArticlePO write(ArticlePO articlePO) {
        return articleDAO.insertArticle(articlePO);
    }

    public ResponseEntity deleteArticle(int id) {
        articleDAO.deleteArticle(id);
        return ApiResult.success("删除成功");
    }

    public ArticlePO updateArticle(ArticlePO articlePO) {
        if(articleDAO.updateArticle(articlePO) != 1){
           AppearException.appearBusinessException(ErrorCode.ARTICLE_EDIT_WRONG);
        }
        return articleDAO.findArticlePOById(articlePO.getId());
    }

    public ArticleVO getArticleVOByUrlTitle(String urlTitle) {
        ArticleVO article = articleDAO.findArticleVOByUrlTitle(urlTitle);
        if (article == null) {
            AppearException.appearBusinessException(ErrorCode.ARTICLE_NOT_EXIST);
        }
        return article;
    }

    public Page listArticles(int offset, int limit) {
        Page page = null;
        Page.PageBuilder pageBuilder = new Page.PageBuilder<>().offset(offset).limit(limit);
        try {
             page = CompletableFuture
                    .supplyAsync(() -> articleDAO.listArticles(pageBuilder))
                    .thenApplyAsync((Function<List<ArticlePO>, List<ArticleVO>>) articlePOs -> {
                        List<Integer> userIdList = new ArrayList();
                        articlePOs.forEach((articlePO) -> userIdList.add(articlePO.getUserId()));
                        List<UserVO> userVOs = userDAO.listUserVOByIdlist(userIdList);
                        List<ArticleVO> articleVOs = new ArrayList<>();
                        for (int i = 0; i < articlePOs.size(); i++) {
                            ArticleVO articleVO = new ArticleVO();
                            BeanUtils.copyProperties(articlePOs.get(i), articleVO);
                            articleVO.setUser(userVOs.get(i));
                            articleVOs.add(articleVO);
                        }
                        return articleVOs;
                    }).thenApplyAsync(new Function<List<ArticleVO>, Page>() {
                        @Override
                        public Page apply(List<ArticleVO> articleVOs) {
                            return pageBuilder.data(articleVOs).count(articleDAO.countArticles()).build();
                        }
                    }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return page;
    }
}



