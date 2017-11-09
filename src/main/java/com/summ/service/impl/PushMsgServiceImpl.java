package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.PushMsgMapper;
import com.summ.model.PushMsg;
import com.summ.service.IPushMsgService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * PushMsg 表数据服务层接口实现类
 *
 */
@Service
public class PushMsgServiceImpl extends SuperServiceImpl<PushMsgMapper, PushMsg> implements IPushMsgService {


}