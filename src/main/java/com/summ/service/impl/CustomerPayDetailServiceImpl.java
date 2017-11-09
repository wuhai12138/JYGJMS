package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CustomerPayDetailMapper;
import com.summ.model.CustomerPayDetail;
import com.summ.service.ICustomerPayDetailService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * CustomerPayDetail 表数据服务层接口实现类
 *
 */
@Service
public class CustomerPayDetailServiceImpl extends SuperServiceImpl<CustomerPayDetailMapper, CustomerPayDetail> implements ICustomerPayDetailService {


}