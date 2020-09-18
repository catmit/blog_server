package com.catmit.blog.server.web.entity.vo;

import com.catmit.blog.server.web.exception.BusinessException;
import com.catmit.blog.server.web.exception.ErrorCode;
import org.springframework.http.ResponseEntity;

public class ApiResult<T> {
    public static ResponseEntity success(String msg){
        return ResponseEntity.ok(msg);
    }

    public static ResponseEntity<ErrorCode> error(BusinessException e){
        return new ResponseEntity<>(e.getErrorCode(), e.getHttpStatus());
    }
}
