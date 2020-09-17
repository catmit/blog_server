package com.catmit.blog.server.web.entity.vo;

import com.catmit.blog.server.web.exception.BusinessException;
import com.catmit.blog.server.web.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResult<T> {
    public ResponseEntity<T> success(){
        return new ResponseEntity<T>(HttpStatus.OK);
    }

    public ResponseEntity<T> success(T data){
        return new ResponseEntity<T>(data, HttpStatus.OK);
    }

    public static ResponseEntity<ErrorCode> error(BusinessException e){
        return new ResponseEntity<>(e.getErrorCode(), e.getHttpStatus());
    }
}
