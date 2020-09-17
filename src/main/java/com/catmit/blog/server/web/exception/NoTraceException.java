package com.catmit.blog.server.web.exception;

public class NoTraceException extends RuntimeException {
    public NoTraceException(String msg){
        super(msg, null, false,false);
    }
}
