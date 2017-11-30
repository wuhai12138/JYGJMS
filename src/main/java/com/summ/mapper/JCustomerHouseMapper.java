package com.summ.mapper;

import com.summ.model.JCustomerHouse;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.response.CustomerHouseRes;

import java.util.List;

/**
 *
 * JCustomerHouse 表数据库控制层接口
 *
 */
public interface JCustomerHouseMapper extends AutoMapper<JCustomerHouse> {

    List<CustomerHouseRes> getList(int CustomerId);

    int deleteList(List<Integer> list);
}