package com.catmit.blog.server.web.controller;

import com.catmit.blog.server.web.model.vo.ApiResult;
import com.catmit.blog.server.web.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionController {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity handlerBusinessException(BusinessException e){
        return ApiResult.error(e);
    }
}
