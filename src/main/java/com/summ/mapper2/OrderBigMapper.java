package com.summ.mapper2;

import com.summ.model2.OrderBig;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.List;

/**
 *
 * OrderBig 表数据库控制层接口
 *
 */
public interface OrderBigMapper extends AutoMapper<OrderBig> {
    List<OrderBig> getOrderList();
}