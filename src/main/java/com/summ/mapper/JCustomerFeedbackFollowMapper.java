package com.summ.mapper;

import com.summ.model.JCustomerFeedbackFollow;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.response.CustomerFeedbackFollowRes;

import java.util.List;

/**
 *
 * JCustomerFeedbackFollow 表数据库控制层接口
 *
 */
public interface JCustomerFeedbackFollowMapper extends AutoMapper<JCustomerFeedbackFollow> {
    List<CustomerFeedbackFollowRes> getCustomerFeedbackFollowList(int feedbackId);

}