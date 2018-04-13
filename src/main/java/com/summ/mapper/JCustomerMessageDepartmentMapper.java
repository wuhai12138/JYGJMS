package com.summ.mapper;

import com.summ.model.JCustomerMessageDepartment;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.response.CustomerFeedbackDepartmentRes;

import java.util.List;

/**
 *
 * JCustomerMessageDepartment 表数据库控制层接口
 *
 */
public interface JCustomerMessageDepartmentMapper extends AutoMapper<JCustomerMessageDepartment> {

    /**
     * 获取反馈部门
     * @param messageId
     * @return
     */
    List<CustomerFeedbackDepartmentRes> getCustomerFeedbackDepartment(Integer messageId);
}