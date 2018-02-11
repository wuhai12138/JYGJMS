package com.summ.model.response;

import java.math.BigDecimal;

public class PayDataRes {
    private Integer customerId;
    private String customerName;
    private String customerPhone;
    private BigDecimal customerBalance;
    private BigDecimal cost;

    public PayDataRes() {
    }

    public PayDataRes(Integer customerId, String customerName, String customerPhone, BigDecimal customerBalance, BigDecimal cost) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerBalance = customerBalance;
        this.cost = cost;
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

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public BigDecimal getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(BigDecimal customerBalance) {
        this.customerBalance = customerBalance;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
