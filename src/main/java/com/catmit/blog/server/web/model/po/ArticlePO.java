package com.catmit.blog.server.web.model.po;

import com.catmit.blog.server.web.model.BaseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class ArticlePO extends BaseEntity {
    private String urlTitle;
    private String contentUrl;
    private String coverUrl;
    private String brief;
    private LocalDateTime editTime;

    private int userId;

    public String getUrlTitle() {
        return urlTitle;
    }

    public void setUrlTitle(String urlTitle) {
        this.urlTitle = urlTitle;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }
}
