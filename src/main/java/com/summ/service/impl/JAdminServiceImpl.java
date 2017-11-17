package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.JAdminMapper;
import com.summ.model.JAdmin;
import com.summ.service.IJAdminService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * JAdmin 表数据服务层接口实现类
 *
 */
@Service
public class JAdminServiceImpl extends SuperServiceImpl<JAdminMapper, JAdmin> implements IJAdminService {


}