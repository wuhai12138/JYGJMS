package com.summ.mapper;

import com.summ.model.JCustomerFeedback;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.CustomerFeedbackReq;
import com.summ.model.response.CustomerFeedbackRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * JCustomerFeedback 表数据库控制层接口
 *
 */
public interface JCustomerFeedbackMapper extends AutoMapper<JCustomerFeedback> {

    int getCustomerFeedbackCount(@Param("customerFeedbackReq") CustomerFeedbackReq customerFeedbackReq);
    List<CustomerFeedbackRes> getCustomerFeedbackList(@Param("customerFeedbackReq") CustomerFeedbackReq customerFeedbackReq);
    CustomerFeedbackRes getCustomerFeedbackDetail(int feedbackId);


}