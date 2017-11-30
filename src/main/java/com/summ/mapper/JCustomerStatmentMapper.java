package com.summ.mapper;

import com.summ.model.JCustomerStatment;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.CustomerStatmentReq;
import com.summ.model.response.CustomerStatmentRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * JCustomerStatment 表数据库控制层接口
 *
 */
public interface JCustomerStatmentMapper extends AutoMapper<JCustomerStatment> {

    int getCount(@Param("customerStatmentReq") CustomerStatmentReq customerStatmentReq);

    List<CustomerStatmentRes> getStatmentList(@Param("customerStatmentReq") CustomerStatmentReq customerStatmentReq);

}