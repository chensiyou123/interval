package com.interval.service.service.impl;

import com.interval.service.dao.AdminUserDao;
import com.interval.service.model.AdminUserEntity;
import com.interval.service.model.AppLoginModel;
import com.interval.service.model.UserEntity;
import com.interval.service.service.AdminUserService;
import com.interval.service.utils.MD5;
import com.interval.service.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;
    @Override
    public R login(Map map, HttpServletRequest request) {
        //1.根据用户信息查询管理员
        List<AdminUserEntity> adminUserEntitys = adminUserDao.query(map);
        if (CollectionUtils.isEmpty(adminUserEntitys)){
            //2.管理员为空查询普通用户
            //List<UserEntity> userList = adminUserDao.query(appLoginModel.getAccount());

        }
        return null;
    }
}
