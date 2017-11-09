package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.ShopMapper;
import com.summ.model.Shop;
import com.summ.service.IShopService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Shop 表数据服务层接口实现类
 *
 */
@Service
public class ShopServiceImpl extends SuperServiceImpl<ShopMapper, Shop> implements IShopService {


}