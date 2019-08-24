package com.interval.service.dao;

import com.interval.service.model.SchoolEntity;
import com.interval.service.utils.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Repository
public interface SchoolDao extends BaseDao<SchoolEntity> {

    /**
     * 条件查询学校
     * @param map
     * @return
     */
    List<SchoolEntity> query(Map map);

}
