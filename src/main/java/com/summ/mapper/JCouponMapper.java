package com.summ.mapper;

import com.summ.model.JCoupon;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.List;

/**
 *
 * JCoupon 表数据库控制层接口
 *
 */
public interface JCouponMapper extends AutoMapper<JCoupon> {

    List<JCoupon> getCouponList(int couponOri);

    JCoupon getCouponByCouponListId(int couponListId);

}