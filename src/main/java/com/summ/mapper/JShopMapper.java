package com.summ.mapper;

import com.summ.model.JShop;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.utils.JsonUtil;

import java.util.List;

/**
 *
 * JShop 表数据库控制层接口
 *
 */
public interface JShopMapper extends AutoMapper<JShop> {
    List<JShop> getShopList();
}