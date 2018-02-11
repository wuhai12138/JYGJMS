package com.summ.model.response;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;
import java.util.List;

/**
 * Created by jygj_7500 on 18/1/28.
 */
public class CustomerFeedbackRes {

    /** 客户反馈表 */
    @TableId(type = IdType.AUTO)
    private Integer feedbackId;

    /**  */
    private String content;

    /** 客户 */
    private Integer customerId;

    /**  */
    private Date createDate = new Date();

    /** 处理部门id */
    private String department;

    /** 状态 */
    private Integer status;

    /** 记录人id */
    private Integer noteAdmin;

    /**  */
    private Integer isDel;

    private String customerName;
    private String customerPhone;
    private String departmentInfo;
    private String statusInfo;
    private List<CustomerFeedbackFollowRes> customerFeedbackFollowResList;

    public List<CustomerFeedbackFollowRes> getCustomerFeedbackFollowResList() {
        return customerFeedbackFollowResList;
    }

    public void setCustomerFeedbackFollowResList(List<CustomerFeedbackFollowRes> customerFeedbackFollowResList) {
        this.customerFeedbackFollowResList = customerFeedbackFollowResList;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNoteAdmin() {
        return noteAdmin;
    }

    public void setNoteAdmin(Integer noteAdmin) {
        this.noteAdmin = noteAdmin;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(String departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }
}
