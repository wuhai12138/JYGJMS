package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.JCustomerMapper;
import com.summ.model.JCustomer;
import com.summ.service.IJCustomerService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * JCustomer 表数据服务层接口实现类
 *
 */
@Service
public class JCustomerServiceImpl extends SuperServiceImpl<JCustomerMapper, JCustomer> implements IJCustomerService {


}