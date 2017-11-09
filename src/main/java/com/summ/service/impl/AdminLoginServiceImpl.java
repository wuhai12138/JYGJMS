package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.AdminLoginMapper;
import com.summ.model.AdminLogin;
import com.summ.service.IAdminLoginService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * AdminLogin 表数据服务层接口实现类
 *
 */
@Service
public class AdminLoginServiceImpl extends SuperServiceImpl<AdminLoginMapper, AdminLogin> implements IAdminLoginService {


}