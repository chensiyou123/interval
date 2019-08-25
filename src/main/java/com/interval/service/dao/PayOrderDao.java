package com.interval.service.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.interval.service.model.PayOrderEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

@Repository
public interface PayOrderDao extends BaseMapper<PayOrderEntity> {
    BigDecimal getTodayIncome(Map map);

}
