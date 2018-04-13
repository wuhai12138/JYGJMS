package com.summ.model;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("j_order_refund")
public class JOrderRefund implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 订单退款表 */
	@TableId(type = IdType.AUTO)
	private Integer refundId;

	/**  */
	private Integer customerId;

	/**  */
	private Integer orderType;

	/**  */
	private Integer orderId;

	/**  */
	private Integer scheduleId;

	/** 支付方式 */
	private Integer payWay;

	/** 退款方式 */
	private Integer rufundWay;

	/** 审核状态 */
	private Integer checkStatus;

	/** 退款原因 */
	private Integer reason;

	/**  */
	private BigDecimal money;

	/**  */
	private String remark;

	/**  */
	private Integer createId;

	/**  */
	private Date createDate;

	/**  */
	private Integer checkId;

	/**  */
	private Date checkDate;

	/**  */
	private Integer isDel;

	public JOrderRefund() {
	}

	public JOrderRefund(Integer customerId, Integer orderType, Integer orderId, Integer scheduleId, Integer payWay, Integer rufundWay, Integer reason, BigDecimal money, String remark) {
		this.customerId = customerId;
		this.orderType = orderType;
		this.orderId = orderId;
		this.scheduleId = scheduleId;
		this.payWay = payWay;
		this.rufundWay = rufundWay;
		this.reason = reason;
		this.money = money;
		this.remark = remark;
	}

	public Integer getRefundId() {
		return this.refundId;
	}

	public void setRefundId(Integer refundId) {
		this.refundId = refundId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getPayWay() {
		return this.payWay;
	}

	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}

	public Integer getRufundWay() {
		return this.rufundWay;
	}

	public void setRufundWay(Integer rufundWay) {
		this.rufundWay = rufundWay;
	}

	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Integer getReason() {
		return this.reason;
	}

	public void setReason(Integer reason) {
		this.reason = reason;
	}

	public BigDecimal getMoney() {
		return this.money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCreateId() {
		return this.createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCheckId() {
		return this.checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
