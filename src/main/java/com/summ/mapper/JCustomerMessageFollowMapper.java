package com.summ.mapper;

import com.summ.model.JCustomerMessageFollow;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.response.CustomerFeedbackFollowRes;

import java.util.List;

/**
 *
 * JCustomerMessageFollow 表数据库控制层接口
 *
 */
public interface JCustomerMessageFollowMapper extends AutoMapper<JCustomerMessageFollow> {
    List<CustomerFeedbackFollowRes> getCustomerFeedbackFollowList(int messageId);

}