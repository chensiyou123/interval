package com.interval.service.utils;

public class ThreadCache {
    /**时间缓存**/
    private static ThreadLocal<Long> timeThreadLocal = new ThreadLocal<Long>();
    public static Long getTimeThreadLocal(){
        return timeThreadLocal.get() == null ? System.currentTimeMillis(): timeThreadLocal.get();
    }
}
