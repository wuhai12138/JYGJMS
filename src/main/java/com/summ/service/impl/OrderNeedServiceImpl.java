package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.OrderNeedMapper;
import com.summ.model.OrderNeed;
import com.summ.service.IOrderNeedService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * OrderNeed 表数据服务层接口实现类
 *
 */
@Service
public class OrderNeedServiceImpl extends SuperServiceImpl<OrderNeedMapper, OrderNeed> implements IOrderNeedService {


}