package com.interval.service.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.interval.service.model.PayOrderEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

@Repository
public interface PayOrderDao extends BaseMapper<PayOrderEntity> {
    /**
     * 今天订单总金额
     * @param map
     * @return
     */
    BigDecimal getTodayIncome(Map map);

}
