package com.summ.mapper;

import com.summ.model.JCouponList;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.CustomerCouponReq;
import com.summ.model.response.CustomerCouponListRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * JCouponList 表数据库控制层接口
 *
 */
public interface JCouponListMapper extends AutoMapper<JCouponList> {

    int deleteCoupon(int id);

    List<CustomerCouponListRes> getListById(@Param("customerCouponReq") CustomerCouponReq customerCouponReq);

    Integer getCount(@Param("customerCouponReq") CustomerCouponReq customerCouponReq);

}