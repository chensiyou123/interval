package com.interval.service.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.interval.service.model.AdminUserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminUserDao  extends BaseMapper<AdminUserEntity> {
    /**
     * 条件查询用户信息
     * @param map{
     *           account：账号
     *           password：密码
     * }
     * @return
     */
    List<AdminUserEntity> query(Map map);
}
