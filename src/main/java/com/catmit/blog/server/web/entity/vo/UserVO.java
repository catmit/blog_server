package com.catmit.blog.server.web.entity.vo;

import com.catmit.blog.server.web.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

public class UserVO extends BaseEntity {

    private String name;
    private String avatarUrl;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<ArticleVO> articles;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<CommentVO> comments;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<ReplyVO> replies;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Set<ArticleVO> getArticles() {
        return articles;
    }

    public void setArticles(Set<ArticleVO> articles) {
        this.articles = articles;
    }

    public Set<CommentVO> getComments() {
        return comments;
    }

    public void setComments(Set<CommentVO> comments) {
        this.comments = comments;
    }

    public Set<ReplyVO> getReplies() {
        return replies;
    }

    public void setReplies(Set<ReplyVO> replies) {
        this.replies = replies;
    }
}
