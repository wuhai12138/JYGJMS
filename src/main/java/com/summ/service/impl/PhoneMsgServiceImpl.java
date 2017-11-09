package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.PhoneMsgMapper;
import com.summ.model.PhoneMsg;
import com.summ.service.IPhoneMsgService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * PhoneMsg 表数据服务层接口实现类
 *
 */
@Service
public class PhoneMsgServiceImpl extends SuperServiceImpl<PhoneMsgMapper, PhoneMsg> implements IPhoneMsgService {


}