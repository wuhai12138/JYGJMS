package com.summ.mapper;

import com.summ.model.JGoodsCost;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.response.OrderTempSupplierRes;

import java.util.List;

/**
 *
 * JGoodsCost 表数据库控制层接口
 *
 */
public interface JGoodsCostMapper extends AutoMapper<JGoodsCost> {
    List<OrderTempSupplierRes> getSupplierList(Integer orderId,String supplierName);

}