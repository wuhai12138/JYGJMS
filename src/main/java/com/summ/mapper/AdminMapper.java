package com.summ.mapper;

import com.summ.model.Admin;
import com.baomidou.mybatisplus.mapper.AutoMapper;

/**
 *
 * Admin 表数据库控制层接口
 *
 */
public interface AdminMapper extends AutoMapper<Admin> {
    Integer getCount();


}