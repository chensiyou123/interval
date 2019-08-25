package com.interval.service.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.interval.service.model.SchoolEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SchoolDao extends BaseMapper<SchoolEntity> {

    /**
     * 条件查询学校
     * @param map
     * @return
     */
    List<SchoolEntity> query(Map map);

    /**
     * 查询学校总数
     * @param map
     * @return
     */
    int queryTotal(Map map);

}
