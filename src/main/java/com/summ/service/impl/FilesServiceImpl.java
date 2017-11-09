package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.FilesMapper;
import com.summ.model.Files;
import com.summ.service.IFilesService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Files 表数据服务层接口实现类
 *
 */
@Service
public class FilesServiceImpl extends SuperServiceImpl<FilesMapper, Files> implements IFilesService {


}