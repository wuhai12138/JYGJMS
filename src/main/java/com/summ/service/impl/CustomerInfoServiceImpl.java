package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CustomerInfoMapper;
import com.summ.model.CustomerInfo;
import com.summ.service.ICustomerInfoService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * CustomerInfo 表数据服务层接口实现类
 *
 */
@Service
public class CustomerInfoServiceImpl extends SuperServiceImpl<CustomerInfoMapper, CustomerInfo> implements ICustomerInfoService {


}