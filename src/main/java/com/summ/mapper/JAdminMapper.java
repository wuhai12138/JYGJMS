package com.summ.mapper;

import com.summ.model.JAdmin;
import com.baomidou.mybatisplus.mapper.AutoMapper;

/**
 * JAdmin 表数据库控制层接口
 */
public interface JAdminMapper extends AutoMapper<JAdmin> {

    JAdmin getAdminById(Integer id);
}