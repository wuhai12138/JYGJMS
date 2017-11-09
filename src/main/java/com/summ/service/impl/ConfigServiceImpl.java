package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.ConfigMapper;
import com.summ.model.Config;
import com.summ.service.IConfigService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Config 表数据服务层接口实现类
 *
 */
@Service
public class ConfigServiceImpl extends SuperServiceImpl<ConfigMapper, Config> implements IConfigService {


}