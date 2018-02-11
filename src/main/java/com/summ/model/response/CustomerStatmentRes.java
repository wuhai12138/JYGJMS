package com.summ.model.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jygj_7500 on 17/11/29.
 */
public class CustomerStatmentRes {

    private Integer statmentId;

    private String statmentCustomer;

    /**  */
    private Integer customerId;

    /**  */
    private Integer goodsId;

    /**  */
    private Integer houseId;

    /**  */
    private Integer orderId;

    /** 日程Id */
    private Integer scheduleId;

    /**  */
    private Integer shopId;

    /** 服务时间（几点到几点） */
    private String serviceTime;

    /** 服务时长 */
    private Double serviceTimeLength;

    /** 服务日期 */
    private Date serviceDate;

    /** 支付日期 */
    private Date chargeDate;

    /** 客户对账单类型 */
    private Integer statmentCustomerType;

    /** 支付金额 */
    private BigDecimal chargeMoney;

    /** 充值方式 */
    private Integer chargeWay;

    /**  */
    private Integer adminId;

    /** 终端 */
    private Integer terminal;

    /** 状态 */
    private Integer status;

    /** 余额 */
    private BigDecimal balance;

    /** 流水号 */
    private Integer serialNumber;

    /**  */
    private String remark;

    /**  */
    private String withdrawlCard;

    /**  */
    private String withdrawlBank;

    private String statusInfo;
    private String terminalInfo;
    private String adminName;
    private String chargeWayInfo;
    private String statmentCustomerTypeInfo;

    public Integer getStatmentId() {
        return statmentId;
    }

    public void setStatmentId(Integer statmentId) {
        this.statmentId = statmentId;
    }

    public String getStatmentCustomer() {
        return statmentCustomer;
    }

    public void setStatmentCustomer(String statmentCustomer) {
        this.statmentCustomer = statmentCustomer;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public Integer getStatmentCustomerType() {
        return statmentCustomerType;
    }

    public void setStatmentCustomerType(Integer statmentCustomerType) {
        this.statmentCustomerType = statmentCustomerType;
    }

    public BigDecimal getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(BigDecimal chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public Integer getChargeWay() {
        return chargeWay;
    }

    public void setChargeWay(Integer chargeWay) {
        this.chargeWay = chargeWay;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWithdrawlCard() {
        return withdrawlCard;
    }

    public void setWithdrawlCard(String withdrawlCard) {
        this.withdrawlCard = withdrawlCard;
    }

    public String getWithdrawlBank() {
        return withdrawlBank;
    }

    public void setWithdrawlBank(String withdrawlBank) {
        this.withdrawlBank = withdrawlBank;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getTerminalInfo() {
        return terminalInfo;
    }

    public void setTerminalInfo(String terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getChargeWayInfo() {
        return chargeWayInfo;
    }

    public void setChargeWayInfo(String chargeWayInfo) {
        this.chargeWayInfo = chargeWayInfo;
    }

    public String getStatmentCustomerTypeInfo() {
        return statmentCustomerTypeInfo;
    }

    public void setStatmentCustomerTypeInfo(String statmentCustomerTypeInfo) {
        this.statmentCustomerTypeInfo = statmentCustomerTypeInfo;
    }
}
