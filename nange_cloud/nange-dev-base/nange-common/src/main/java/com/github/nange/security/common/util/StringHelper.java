package com.github.nange.security.common.util;

public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
