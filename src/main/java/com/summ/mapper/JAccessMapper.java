package com.summ.mapper;

import com.summ.model.JAccess;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.List;

/**
 *
 * JAccess 表数据库控制层接口
 *
 * @author jygj_7500
 */
public interface JAccessMapper extends AutoMapper<JAccess> {

    List<JAccess> getListOrderBySort();

}