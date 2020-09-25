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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    /*
    未完成
        list<articlePo>-> list<userId> -> list<user>
        list<articlePo> + list<user> -> list<ArticleVO>
     */
    public Page listArticles(int offset, int limit) {
        Page.PageBuilder pageBuilder = new Page.PageBuilder<>().offset(offset).limit(limit);
        List<ArticlePO> articlePOs = articleDAO.listArticles(pageBuilder);
        List<Integer> userIdList = new ArrayList();
        articlePOs.forEach((articlePO)->userIdList.add(articlePO.getUserId()));
        List<ArticleVO> articles = null;
        Page page = pageBuilder.data(articles).count(articleDAO.countArticles()).build();
        return page;
    }
}



