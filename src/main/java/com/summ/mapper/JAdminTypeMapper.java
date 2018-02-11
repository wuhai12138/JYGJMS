package com.summ.mapper;

import com.summ.model.JAdminType;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.response.AdminTypeRes;

import java.util.List;

/**
 *
 * JAdminType 表数据库控制层接口
 *
 */
public interface JAdminTypeMapper extends AutoMapper<JAdminType> {

    List<AdminTypeRes> getadminTypeById(int adminId);


}