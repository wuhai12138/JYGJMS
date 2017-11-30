package com.summ.mapper;

import com.summ.model.JDictInfo;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.List;

/**
 *
 * JDictInfo 表数据库控制层接口
 *
 */
public interface JDictInfoMapper extends AutoMapper<JDictInfo> {

    List<JDictInfo> getList(int typeCode);

}