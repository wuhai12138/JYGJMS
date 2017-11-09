package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.SuggestMapper;
import com.summ.model.Suggest;
import com.summ.service.ISuggestService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Suggest 表数据服务层接口实现类
 *
 */
@Service
public class SuggestServiceImpl extends SuperServiceImpl<SuggestMapper, Suggest> implements ISuggestService {


}