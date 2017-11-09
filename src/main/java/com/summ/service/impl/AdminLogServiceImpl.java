package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.AdminLogMapper;
import com.summ.model.AdminLog;
import com.summ.service.IAdminLogService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * AdminLog 表数据服务层接口实现类
 *
 */
@Service
public class AdminLogServiceImpl extends SuperServiceImpl<AdminLogMapper, AdminLog> implements IAdminLogService {


}