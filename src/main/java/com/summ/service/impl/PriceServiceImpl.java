package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.PriceMapper;
import com.summ.model.Price;
import com.summ.service.IPriceService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Price 表数据服务层接口实现类
 *
 */
@Service
public class PriceServiceImpl extends SuperServiceImpl<PriceMapper, Price> implements IPriceService {


}