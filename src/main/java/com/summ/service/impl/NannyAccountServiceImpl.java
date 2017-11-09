package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.NannyAccountMapper;
import com.summ.model.NannyAccount;
import com.summ.service.INannyAccountService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * NannyAccount 表数据服务层接口实现类
 *
 */
@Service
public class NannyAccountServiceImpl extends SuperServiceImpl<NannyAccountMapper, NannyAccount> implements INannyAccountService {


}