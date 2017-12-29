package com.summ.mapper;

import com.summ.model.JDictInfo;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.utils.StringUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * JDictInfo 表数据库控制层接口
 *
 */
public interface JDictInfoMapper extends AutoMapper<JDictInfo> {

    List<JDictInfo> getList(int typeCode, @Param("info") String info);

}