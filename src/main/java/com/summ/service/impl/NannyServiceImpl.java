package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.NannyMapper;
import com.summ.model.Nanny;
import com.summ.service.INannyService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Nanny 表数据服务层接口实现类
 *
 */
@Service
public class NannyServiceImpl extends SuperServiceImpl<NannyMapper, Nanny> implements INannyService {


}