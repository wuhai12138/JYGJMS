package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CustomerServiceMapper;
import com.summ.model.CustomerService;
import com.summ.service.ICustomerServiceService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * CustomerService 表数据服务层接口实现类
 *
 */
@Service
public class CustomerServiceServiceImpl extends SuperServiceImpl<CustomerServiceMapper, CustomerService> implements ICustomerServiceService {


}