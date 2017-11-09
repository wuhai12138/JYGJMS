package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.NewsMapper;
import com.summ.model.News;
import com.summ.service.INewsService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * News 表数据服务层接口实现类
 *
 */
@Service
public class NewsServiceImpl extends SuperServiceImpl<NewsMapper, News> implements INewsService {


}