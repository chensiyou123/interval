package com.interval.service.component;

import com.interval.service.dao.PayOrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Component
@Slf4j
public class LockRedisUtils {

    private final String NEW_USER_COUNT_CACHE_NAME = "count:todayNewUser";
    private final String TODAY_INCOME_COUNT_CACHE_NAME = "count:todayIncome";
    public final static long NOT_EXPIRE = -1;   // 不设置过期时长

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private PayOrderDao payOrderDao;
    private final ReentrantReadWriteLock newUserCountLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock incomeCountLock = new ReentrantReadWriteLock();

    /**
     * 今天新增用户数
     * @return
     */
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

    /**
     * 查询今天订单总金额
     * @return
     */
    public BigDecimal getTodayIncomeCount(){
        //加上读锁，其它线程可读不可写
        if (!incomeCountLock.isWriteLockedByCurrentThread()){
            incomeCountLock.readLock().lock();
        }
        BigDecimal count = BigDecimal.ZERO;
        try{
            count = redisUtils.get(TODAY_INCOME_COUNT_CACHE_NAME, BigDecimal.class);
            if (count == null){
                count = payOrderDao.getTodayIncome(null);
                if (count != null){
                    redisUtils.set(TODAY_INCOME_COUNT_CACHE_NAME,count);
                }
            }
        }finally {
            if (!incomeCountLock.isWriteLockedByCurrentThread()){
                incomeCountLock.readLock().unlock();
            }
        }
        return Objects.isNull(count)?new BigDecimal(0):count;
    }

}
