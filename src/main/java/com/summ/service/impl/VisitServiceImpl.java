package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.VisitMapper;
import com.summ.model.Visit;
import com.summ.service.IVisitService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Visit 表数据服务层接口实现类
 *
 */
@Service
public class VisitServiceImpl extends SuperServiceImpl<VisitMapper, Visit> implements IVisitService {


}