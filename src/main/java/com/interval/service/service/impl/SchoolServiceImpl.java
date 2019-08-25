package com.interval.service.service.impl;

import com.interval.service.dao.SchoolDao;
import com.interval.service.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolDao schoolDao;
    @Override
    public int queryTotal(Map map) {
        return schoolDao.queryTotal(map);
    }
}
