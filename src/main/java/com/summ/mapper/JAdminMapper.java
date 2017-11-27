package com.summ.mapper;

import com.summ.model.JAdmin;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.PaginateReq;
import com.summ.model.response.AccessRes;

import java.util.List;

/**
 * JAdmin 表数据库控制层接口
 */
public interface JAdminMapper extends AutoMapper<JAdmin> {

    JAdmin getAdminById(Integer id);

    List<JAdmin> getAdminList(PaginateReq paginateReq);

    List<AccessRes> getAccess(int adminId);

    int deleteAdmin(int id);

    int getCount();

}