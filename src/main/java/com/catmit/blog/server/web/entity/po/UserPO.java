package com.catmit.blog.server.web.entity.po;

import com.catmit.blog.server.web.entity.BaseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class UserPO extends BaseEntity {
    private String name;
    private String mail;
    private String password;
    private String avatarUrl;
    private LocalDateTime updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
