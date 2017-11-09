package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.NannyInfoMapper;
import com.summ.model.NannyInfo;
import com.summ.service.INannyInfoService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * NannyInfo 表数据服务层接口实现类
 *
 */
@Service
public class NannyInfoServiceImpl extends SuperServiceImpl<NannyInfoMapper, NannyInfo> implements INannyInfoService {


}