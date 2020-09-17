package com.catmit.blog.server.web.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    USER_NOT_EXIST(404001, "用户不存在");

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
