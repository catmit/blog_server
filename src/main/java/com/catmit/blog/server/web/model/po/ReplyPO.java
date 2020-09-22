package com.catmit.blog.server.web.model.po;

import com.catmit.blog.server.web.model.BaseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyPO extends BaseEntity {
    private String content;

    private int senderId;
    private int receiverId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
}
