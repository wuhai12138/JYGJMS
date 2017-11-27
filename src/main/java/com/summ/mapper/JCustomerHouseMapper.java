package com.summ.mapper;

import com.summ.model.JCustomerHouse;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.List;

/**
 *
 * JCustomerHouse 表数据库控制层接口
 *
 */
public interface JCustomerHouseMapper extends AutoMapper<JCustomerHouse> {

    List<JCustomerHouse> getList(int CustomerId);

    int deleteList(List<Integer> list);
}