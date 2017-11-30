package com.summ.model.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jygj_7500 on 17/11/29.
 */
public class CustomerStatmentRes {

    private Integer statmentId;

    /**  */
    private Integer customerId;

    /**  */
    private Date chargeDate = new Date();

    /**  */
    private Integer statmentType;
    private String statmentTypeInfo;

    /**  */
    private Double chargeMoney;

    /**  */
    private Integer chargeWay;
    private String chargeWayInfo;

    /**  */
    private Integer adminId;
    private String adminName;

    /**  */
    private Integer terminal;
    private String terminalInfo;

    /**  */
    private Integer status;
    private String statusInfo;

    /** 余额 */
    private BigDecimal balance;

    /**  */
    private Integer serialNumber;

    /**  */
    private Integer isDel;
    private String isDelInfo;

    /**  */
    private String remark;

    public Integer getStatmentId() {
        return statmentId;
    }

    public void setStatmentId(Integer statmentId) {
        this.statmentId = statmentId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public Integer getStatmentType() {
        return statmentType;
    }

    public void setStatmentType(Integer statmentType) {
        this.statmentType = statmentType;
    }

    public String getStatmentTypeInfo() {
        return statmentTypeInfo;
    }

    public void setStatmentTypeInfo(String statmentTypeInfo) {
        this.statmentTypeInfo = statmentTypeInfo;
    }

    public Double getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(Double chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public Integer getChargeWay() {
        return chargeWay;
    }

    public void setChargeWay(Integer chargeWay) {
        this.chargeWay = chargeWay;
    }

    public String getChargeWayInfo() {
        return chargeWayInfo;
    }

    public void setChargeWayInfo(String chargeWayInfo) {
        this.chargeWayInfo = chargeWayInfo;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    public String getTerminalInfo() {
        return terminalInfo;
    }

    public void setTerminalInfo(String terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
