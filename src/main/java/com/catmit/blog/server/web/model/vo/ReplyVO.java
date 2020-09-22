package com.catmit.blog.server.web.model.vo;

import com.catmit.blog.server.web.model.BaseEntity;

public class ReplyVO extends BaseEntity {
    private String content;

    private UserVO sender;
    private UserVO receiver;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserVO getSender() {
        return sender;
    }

    public void setSender(UserVO sender) {
        this.sender = sender;
    }

    public UserVO getReceiver() {
        return receiver;
    }

    public void setReceiver(UserVO receiver) {
        this.receiver = receiver;
    }
}
