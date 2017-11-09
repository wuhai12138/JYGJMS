package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CustomerMapper;
import com.summ.model.Customer;
import com.summ.service.ICustomerService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Customer 表数据服务层接口实现类
 *
 */
@Service
public class CustomerServiceImpl extends SuperServiceImpl<CustomerMapper, Customer> implements ICustomerService {


}