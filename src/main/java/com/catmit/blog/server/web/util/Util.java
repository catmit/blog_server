package com.catmit.blog.server.web.util;

import org.springframework.beans.BeanUtils;

public class Util {

    public static void copy(Object source, Object target){
        BeanUtils.copyProperties(source, target);
    }

    public void deepCopy(){

    }

}
