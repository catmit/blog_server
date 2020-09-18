package com.catmit.blog.server.web.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static ExecutorService pool(){
        return executorService;
    }
}
