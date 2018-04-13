package com.summ.mapper;

import com.summ.model.JCoupon;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.CouponReq;
import com.summ.model.response.CouponRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * JCoupon 表数据库控制层接口
 *
 */
public interface JCouponMapper extends AutoMapper<JCoupon> {

    List<CouponRes> getCouponList(@Param("couponReq") CouponReq couponReq);

    JCoupon getCouponByCouponListId(int couponListId);

}