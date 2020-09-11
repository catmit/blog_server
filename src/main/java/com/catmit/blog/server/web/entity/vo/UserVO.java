package com.catmit.blog.server.web.entity.vo;

import com.catmit.blog.server.web.entity.BaseEntity;

public class UserVO extends BaseEntity {

    private String name;
    private String avatarUrl;

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
}
