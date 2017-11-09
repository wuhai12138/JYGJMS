package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CustomerHouseMapper;
import com.summ.model.CustomerHouse;
import com.summ.service.ICustomerHouseService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * CustomerHouse 表数据服务层接口实现类
 *
 */
@Service
public class CustomerHouseServiceImpl extends SuperServiceImpl<CustomerHouseMapper, CustomerHouse> implements ICustomerHouseService {


}