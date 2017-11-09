package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.ShareholderMapper;
import com.summ.model.Shareholder;
import com.summ.service.IShareholderService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Shareholder 表数据服务层接口实现类
 *
 */
@Service
public class ShareholderServiceImpl extends SuperServiceImpl<ShareholderMapper, Shareholder> implements IShareholderService {


}