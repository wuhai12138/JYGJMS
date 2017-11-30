package com.summ.model.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jygj_7500 on 17/11/28.
 */
public class CustomerRes {
    private Integer customerId;

    /**  */
    private Integer shopId;
    private String shopIdInfo;

    /**  */
    private String customerName;

    /**  */
    private String customerPhone;

    /** 用户类型1注册2会员3僵尸用户 */
    private Integer customerType = 11;
    private String customerTypeInfo;

    /** 1男2女 */
    private Integer customerSex;
    private String customerSexInfo;

    /**  */
    private BigDecimal customerBalance;

    /** 1警告2不警告 */
    private Integer warnType = 15;
    private String warnTypeInfo ;

    /**  */
    private String remark;

    /**  */
    private Date createTime = new Date();

    /** 是否删除（1为已删除） */
    private Integer isDel = 16;
    private String isDelInfo;

    /** 1门店2电话咨询3ios4android */
    private String memberOrigin;

    /**  */
    private Integer memberLevel;

    /**  */
    private Integer memberType;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopIdInfo() {
        return shopIdInfo;
    }

    public void setShopIdInfo(String shopIdInfo) {
        this.shopIdInfo = shopIdInfo;
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

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getCustomerTypeInfo() {
        return customerTypeInfo;
    }

    public void setCustomerTypeInfo(String customerTypeInfo) {
        this.customerTypeInfo = customerTypeInfo;
    }

    public Integer getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(Integer customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerSexInfo() {
        return customerSexInfo;
    }

    public void setCustomerSexInfo(String customerSexInfo) {
        this.customerSexInfo = customerSexInfo;
    }

    public BigDecimal getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(BigDecimal customerBalance) {
        this.customerBalance = customerBalance;
    }

    public Integer getWarnType() {
        return warnType;
    }

    public void setWarnType(Integer warnType) {
        this.warnType = warnType;
    }

    public String getWarnTypeInfo() {
        return warnTypeInfo;
    }

    public void setWarnTypeInfo(String warnTypeInfo) {
        this.warnTypeInfo = warnTypeInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getIsDelInfo() {
        return isDelInfo;
    }

    public void setIsDelInfo(String isDelInfo) {
        this.isDelInfo = isDelInfo;
    }

    public String getMemberOrigin() {
        return memberOrigin;
    }

    public void setMemberOrigin(String memberOrigin) {
        this.memberOrigin = memberOrigin;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }
}
