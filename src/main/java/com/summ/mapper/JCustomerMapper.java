package com.summ.mapper;

import com.summ.model.JCustomer;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.CustomerPagReq;
import com.summ.model.response.CustomerRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * JCustomer 表数据库控制层接口
 */
public interface JCustomerMapper extends AutoMapper<JCustomer> {

    List<CustomerRes> getCustomerList(@Param("customerPagReq") CustomerPagReq customerPagReq);

    Integer getCount(@Param("customerPagReq") CustomerPagReq customerPagReq);

    int deleteList(List<Integer> list);

}