package com.interval.service.dao;

import com.interval.service.model.UserEntity;
import com.interval.service.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao extends BaseDao<UserEntity> {
    /**
     * 条件查询用户信息
     * @param map{
     *           account：账号
     *           password：密码
     *           phone：电话
     *           schoolId:学校id
     *           sex:性别
     *
     * }
     * @return
     */
    List<UserEntity> query(Map map);
}
