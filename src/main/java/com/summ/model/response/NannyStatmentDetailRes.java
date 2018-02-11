package com.summ.model.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jygj_7500 on 18/1/23.
 */
public class NannyStatmentDetailRes {
    private Integer statmentId;

    private String statmentNanny;

    /**  */
    private Integer nannyId;

    /**  */
    private Integer scheduleId;

    /**  */
    private Integer orderId;

    /**  */
    private Integer shopId;
    private String shopName;

    /**  */
    private Integer houseId;
    private String houseAddress;

    /**  */
    private Integer customerId;
    private String customerName;

    /** 服务师对账单类型 */
    private Integer statmentNannyType;
    private String statmentNannyTypeInfo;

    /** 金额 */
    private BigDecimal statmentMoney;

    /** 订单类型 */
    private Integer orderType;


    /** 产品Id */
    private Integer goodsId;
    private String service;

    /** 服务时间（几点到几点） */
    private String serviceTime;

    /** 服务时长 */
    private Double serviceTimeLength;

    /** 服务日期 */
    private Date serviceDate;

    private Date createDate = new Date();

    /**  */
    private String remark;

    public Integer getStatmentId() {
        return statmentId;
    }

    public void setStatmentId(Integer statmentId) {
        this.statmentId = statmentId;
    }

    public String getStatmentNanny() {
        return statmentNanny;
    }

    public void setStatmentNanny(String statmentNanny) {
        this.statmentNanny = statmentNanny;
    }

    public Integer getNannyId() {
        return nannyId;
    }

    public void setNannyId(Integer nannyId) {
        this.nannyId = nannyId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStatmentNannyType() {
        return statmentNannyType;
    }

    public void setStatmentNannyType(Integer statmentNannyType) {
        this.statmentNannyType = statmentNannyType;
    }

    public String getStatmentNannyTypeInfo() {
        return statmentNannyTypeInfo;
    }

    public void setStatmentNannyTypeInfo(String statmentNannyTypeInfo) {
        this.statmentNannyTypeInfo = statmentNannyTypeInfo;
    }

    public BigDecimal getStatmentMoney() {
        return statmentMoney;
    }

    public void setStatmentMoney(BigDecimal statmentMoney) {
        this.statmentMoney = statmentMoney;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Double getServiceTimeLength() {
        return serviceTimeLength;
    }

    public void setServiceTimeLength(Double serviceTimeLength) {
        this.serviceTimeLength = serviceTimeLength;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
