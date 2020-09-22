package com.catmit.blog.server.web.model.vo;

import com.catmit.blog.server.web.exception.BusinessException;
import com.catmit.blog.server.web.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResult<T> extends ResponseEntity<T>{

    private ApiResult(T body, HttpStatus status) {
        super(body, status);
    }

    public static ApiResult success(String msg){
        return new ApiResult(msg, HttpStatus.OK);
    }

    public static ApiResult<ErrorCode> error(BusinessException e){
        return new ApiResult<>(e.getErrorCode(), e.getHttpStatus());
    }
}
