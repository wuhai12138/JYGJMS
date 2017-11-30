package com.summ.mapper;

import com.summ.model.JCouponList;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.List;

/**
 *
 * JCouponList 表数据库控制层接口
 *
 */
public interface JCouponListMapper extends AutoMapper<JCouponList> {

    int deleteCoupon(int id);

    List<JCouponList> getListById(int costomerId);


}