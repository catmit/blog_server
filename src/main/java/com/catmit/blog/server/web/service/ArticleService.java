package com.catmit.blog.server.web.service;

import com.catmit.blog.server.web.dao.ArticleDAO;
import com.catmit.blog.server.web.entity.po.ArticlePO;
import com.catmit.blog.server.web.entity.vo.ApiResult;
import com.catmit.blog.server.web.entity.vo.ArticleVO;
import com.catmit.blog.server.web.entity.vo.Page;
import com.catmit.blog.server.web.exception.AppearException;
import com.catmit.blog.server.web.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticleDAO articleDAO;

    public ArticleVO write(ArticlePO articlePO) {
        return articleDAO.insertArticle(articlePO);
    }

    public ResponseEntity deleteArticle(int id) {
        articleDAO.deleteArticle(id);
        return ApiResult.success("删除成功");
    }

    public ArticleVO updateArticle(ArticlePO articlePO) {
        return articleDAO.updateArticle(articlePO);
    }

    public ArticleVO getArticleVOByUrlTitle(String urlTitle) {
        ArticleVO article = articleDAO.findArticleVOByUrlTitle(urlTitle);
        if (article == null) {
            AppearException.appearBusinessException(ErrorCode.ARTICLE_NOT_EXIST);
        }
        return article;
    }

    public Page listArticles(int offset, int limit) {
        Page.PageBuilder pageBuilder = new Page.PageBuilder<ArticleVO>().offset(offset).limit(limit);
        Page page = pageBuilder.data(articleDAO.listArticles(pageBuilder)).count(articleDAO.countArticles()).build();
        return page;
    }
}



