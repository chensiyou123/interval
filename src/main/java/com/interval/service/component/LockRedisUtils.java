package com.interval.service.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Component
@Slf4j
public class LockRedisUtils {

    private final String NEW_USER_COUNT_CACHE_NAME = "count:todayNewUser";
    @Autowired
    private RedisUtils redisUtils;

    private final ReentrantReadWriteLock newUserCountLock = new ReentrantReadWriteLock();


    public int getNewUserCount(){
        //加上读锁，其它线程可读不可写
        if (!newUserCountLock.isWriteLockedByCurrentThread()){
            newUserCountLock.readLock().lock();
        }
        Integer count = 0;
        try{
            count = redisUtils.get(NEW_USER_COUNT_CACHE_NAME,Integer.class);
        }finally{
            //释放锁
            if (!newUserCountLock.isWriteLockedByCurrentThread()){
                newUserCountLock.readLock().unlock();
            }
        }
        return Objects.isNull(count)?0:count;
    }
}
