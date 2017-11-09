package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CustomerCouponMapper;
import com.summ.model.CustomerCoupon;
import com.summ.service.ICustomerCouponService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * CustomerCoupon 表数据服务层接口实现类
 *
 */
@Service
public class CustomerCouponServiceImpl extends SuperServiceImpl<CustomerCouponMapper, CustomerCoupon> implements ICustomerCouponService {


}