package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.PrepaidMapper;
import com.summ.model.Prepaid;
import com.summ.service.IPrepaidService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Prepaid 表数据服务层接口实现类
 *
 */
@Service
public class PrepaidServiceImpl extends SuperServiceImpl<PrepaidMapper, Prepaid> implements IPrepaidService {


}