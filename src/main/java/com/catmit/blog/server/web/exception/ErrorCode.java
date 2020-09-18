package com.catmit.blog.server.web.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    USER_NOT_EXIST(404001, "用户不存在"),
    INVALID_PASSWORD(404002, "密码错误"),
    EMPTY_PASSWORD(404003,"密码为空"),
    MAIL_ALREADY_EXIST(404004,"邮箱已存在"),

    ARTICLE_NOT_EXIST(404104,"文章不存在");


    private int errorCode;
    private String msg;

    ErrorCode(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public HttpStatus toHttpStatus(){
        return HttpStatus.valueOf(this.errorCode/1000);
    }

    public String msg(){
        return this.msg;
    }

}
