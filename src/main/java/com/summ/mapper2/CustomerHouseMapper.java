package com.summ.mapper2;

import com.summ.model2.CustomerHouse;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model2.response.CustomerHouseRes;

import java.util.List;

/**
 *
 * CustomerHouse 表数据库控制层接口
 *
 */
public interface CustomerHouseMapper extends AutoMapper<CustomerHouse> {
    List<CustomerHouseRes> getCutomerHouse();

}