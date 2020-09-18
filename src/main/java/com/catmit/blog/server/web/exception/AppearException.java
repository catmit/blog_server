package com.catmit.blog.server.web.exception;

public class AppearException {
    public static BusinessException appearBusinessException(ErrorCode errorCode){
        return new BusinessException(errorCode);
    }
}
