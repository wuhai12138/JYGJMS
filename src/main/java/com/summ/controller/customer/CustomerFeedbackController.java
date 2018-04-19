package com.summ.controller.customer;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.*;
import com.summ.model.request.CustomerFeedbackReq;
import com.summ.model.response.CustomerFeedbackFollowRes;
import com.summ.model.response.CustomerFeedbackRes;
import com.summ.model.response.ModelRes;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jygj_7500 on 18/1/27.
 */
@Controller
@RequestMapping("/customer/feedback")
public class CustomerFeedbackController extends AutoMapperController{

    @ResponseBody
    @RequestMapping(value = "/insert")
    public Object insert(@RequestBody Map map, ServletRequest request) {
        try {
            JAdmin admin = (JAdmin) request.getAttribute("admin");
            String content = (String) map.get("content");
            Integer customerId = (Integer) map.get("customerId");
            Integer orderId = (Integer) map.get("orderId");
            Integer scheduleId = (Integer) map.get("scheduleId");
            List<Integer> list = (List<Integer>) map.get("department");

//            JCustomerFeedback jCustomerFeedback = new JCustomerFeedback();
//            jCustomerFeedback.setContent(content);
//            jCustomerFeedback.setCustomerId(customerId);
//            jCustomerFeedback.setNoteAdmin(admin.getAdminId());
//            jCustomerFeedback.setOrderId(orderId);
//            jCustomerFeedback.setScheduleId(scheduleId);
//            jCustomerFeedbackMapper.insert(jCustomerFeedback);

            JCustomerMessage jCustomerMessage = new JCustomerMessage(content,customerId,orderId,scheduleId,new Date(),170,217,admin.getAdminId(),16);
            jCustomerMessageMapper.insertSelective(jCustomerMessage);

//            List<JCustomerFeedbackDepartment> jCustomerFeedbackList = new ArrayList<JCustomerFeedbackDepartment>();
//            for (Integer ii : list){
//                JCustomerFeedbackDepartment jCustomerFeedbackDepartment = new JCustomerFeedbackDepartment(jCustomerFeedback.getFeedbackId(),ii);
//                jCustomerFeedbackList.add(jCustomerFeedbackDepartment);
//            }
//            jCustomerFeedbackDepartmentMapper.insertBatch(jCustomerFeedbackList);

            List<JCustomerMessageDepartment> jCustomerMessageDepartmentList = new ArrayList<JCustomerMessageDepartment>();
            for (Integer ii : list){
                JCustomerMessageDepartment jCustomerMessageDepartment = new JCustomerMessageDepartment(jCustomerMessage.getMessageId(),ii);
                jCustomerMessageDepartmentList.add(jCustomerMessageDepartment);
            }
            jCustomerMessageDepartmentMapper.insertBatch(jCustomerMessageDepartmentList);

            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/find")
    public Object find(@RequestBody CustomerFeedbackReq customerFeedbackRes,ServletRequest request) {
        try {
            JAdmin admin = (JAdmin) request.getAttribute("admin");
            customerFeedbackRes.setPage((customerFeedbackRes.getPage()-1)*customerFeedbackRes.getSize());
            Map map = new HashedMap();
            map.put("count",jCustomerMessageMapper.getCustomerFeedbackCount(customerFeedbackRes));
            List<CustomerFeedbackRes> customerFeedbackResList =jCustomerMessageMapper.getCustomerFeedbackList(customerFeedbackRes);
            for (CustomerFeedbackRes customerFeedbackRes1 : customerFeedbackResList){
                customerFeedbackRes1.setCustomerFeedbackDepartmentResList(jCustomerMessageDepartmentMapper.getCustomerFeedbackDepartment(customerFeedbackRes1.getMessageId()));
            }
            map.put("list",customerFeedbackResList);
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public Object update(@RequestBody JCustomerMessage jCustomerMessage) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !",jCustomerMessageMapper.updateSelectiveById(jCustomerMessage));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 客户反馈详情以及管理员跟踪记录的列表
     * @param jCustomerMessage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/follow/find")
    public Object detail(@RequestBody JCustomerMessage jCustomerMessage) {
        try {
            CustomerFeedbackRes customerFeedbackRes = jCustomerMessageMapper.getCustomerFeedbackDetail(jCustomerMessage.getMessageId());
            List<CustomerFeedbackFollowRes> list = jCustomerMessageFollowMapper.getCustomerFeedbackFollowList(jCustomerMessage.getMessageId());
            if (list.size()>0){
                customerFeedbackRes.setCustomerFeedbackFollowResList(list);
            }
            customerFeedbackRes.setCustomerFeedbackDepartmentResList(jCustomerMessageDepartmentMapper.getCustomerFeedbackDepartment(customerFeedbackRes.getMessageId()));
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !",customerFeedbackRes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/follow/insert")
    public Object detail(@RequestBody JCustomerMessageFollow jCustomerMessageFollow,ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jCustomerMessageFollow.setAdminId(jAdmin.getAdminId());
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !",jCustomerMessageFollowMapper.insertSelective(jCustomerMessageFollow));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }



}
