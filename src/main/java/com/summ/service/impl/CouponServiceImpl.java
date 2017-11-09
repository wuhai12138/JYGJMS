package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CouponMapper;
import com.summ.model.Coupon;
import com.summ.service.ICouponService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Coupon 表数据服务层接口实现类
 *
 */
@Service
public class CouponServiceImpl extends SuperServiceImpl<CouponMapper, Coupon> implements ICouponService {


}