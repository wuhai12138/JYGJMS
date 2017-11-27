package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.JCityMapper;
import com.summ.model.JCity;
import com.summ.service.IJCityService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * JCity 表数据服务层接口实现类
 *
 */
@Service
public class JCityServiceImpl extends SuperServiceImpl<JCityMapper, JCity> implements IJCityService {


}