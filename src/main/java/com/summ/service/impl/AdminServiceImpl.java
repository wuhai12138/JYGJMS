package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.AdminMapper;
import com.summ.model.Admin;
import com.summ.service.IAdminService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Admin 表数据服务层接口实现类
 *
 */
@Service
public class AdminServiceImpl extends SuperServiceImpl<AdminMapper, Admin> implements IAdminService {


}