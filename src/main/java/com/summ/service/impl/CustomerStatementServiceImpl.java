package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CustomerStatementMapper;
import com.summ.model.CustomerStatement;
import com.summ.service.ICustomerStatementService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * CustomerStatement 表数据服务层接口实现类
 *
 */
@Service
public class CustomerStatementServiceImpl extends SuperServiceImpl<CustomerStatementMapper, CustomerStatement> implements ICustomerStatementService {


}