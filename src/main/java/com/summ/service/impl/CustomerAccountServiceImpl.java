package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CustomerAccountMapper;
import com.summ.model.CustomerAccount;
import com.summ.service.ICustomerAccountService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * CustomerAccount 表数据服务层接口实现类
 *
 */
@Service
public class CustomerAccountServiceImpl extends SuperServiceImpl<CustomerAccountMapper, CustomerAccount> implements ICustomerAccountService {


}