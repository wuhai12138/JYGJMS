package com.summ.mapper;

import com.summ.model.JDictType;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.List;

/**
 *
 * JDictType 表数据库控制层接口
 *
 */
public interface JDictTypeMapper extends AutoMapper<JDictType> {
    List<JDictType> selectTypeList();
}