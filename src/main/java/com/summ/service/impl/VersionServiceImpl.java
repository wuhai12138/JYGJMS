package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.VersionMapper;
import com.summ.model.Version;
import com.summ.service.IVersionService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Version 表数据服务层接口实现类
 *
 */
@Service
public class VersionServiceImpl extends SuperServiceImpl<VersionMapper, Version> implements IVersionService {


}