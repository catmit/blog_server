package com.catmit.blog.server.web.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends NoTraceException{

    private ErrorCode errorCode;
    private HttpStatus httpStatus;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.msg());
        this.errorCode = errorCode;
        this.httpStatus = errorCode.toHttpStatus();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
