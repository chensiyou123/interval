package com.interval.service.dao;

import com.interval.service.model.AdminUserEntity;
import com.interval.service.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminUserDao  extends BaseDao<AdminUserEntity> {
    /**
     * 条件查询用户信息
     * @param map
     * @return
     */
    List<AdminUserEntity> query(Map map);
}
