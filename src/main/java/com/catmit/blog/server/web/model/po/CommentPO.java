package com.catmit.blog.server.web.model.po;

import com.catmit.blog.server.web.model.BaseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CommentPO extends BaseEntity {
    private String content;

    private int userId;
    private int articleId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
