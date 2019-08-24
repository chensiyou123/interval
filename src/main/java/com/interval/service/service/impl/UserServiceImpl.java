package com.interval.service.service.impl;

import com.interval.service.component.LockRedisUtils;
import com.interval.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private LockRedisUtils lockRedisUtils;

    @Override
    public int getTodayNewUser(HttpServletRequest request) {
        int count = lockRedisUtils.getNewUserCount();
        return count;
    }
}
