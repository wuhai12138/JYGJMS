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
@TableName("j_order_schedule")
public class JOrderSchedule implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer scheduleId;

	/**  */
	private Integer orderId;

	private Integer orderType;

	/** 对账单 */
	private Integer statmentId;

	private Date scheduleDate;

	/** 单价 */
	private BigDecimal unitPrice=new BigDecimal(0);

	/** 总价 */
	private BigDecimal totalPrice=new BigDecimal(0);

	/** 成本（取决于服务师） */
	private BigDecimal cost=new BigDecimal(0);

	/** 日程状态 */
	private Integer scheduleStatus=152;

	/** 支付状态 */
	private Integer payStatus=157;

	/** 开始时间Id */
	private Integer startTime;

	/** 结束时间Id */
	private Integer endTime;

	private String startTimeValue;

	private String endTimeValue;

	/** 时间值 */
	private Long timeValue;

	/** 签到时间 */
	private Date clockTime;

	/** 完工时间 */
	private Date completedTime;

	/** 暂停时间 */
	private Date suspendTime;

	/** 暂停时间  */
	private Date cancelTime;

	private String weekday;

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getStartTimeValue() {
		return startTimeValue;
	}

	public void setStartTimeValue(String startTimeValue) {
		this.startTimeValue = startTimeValue;
	}

	public String getEndTimeValue() {
		return endTimeValue;
	}

	public void setEndTimeValue(String endTimeValue) {
		this.endTimeValue = endTimeValue;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Long getTimeValue() {
		return timeValue;
	}

	public void setTimeValue(Long timeValue) {
		this.timeValue = timeValue;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public Integer getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getStatmentId() {
		return this.statmentId;
	}

	public void setStatmentId(Integer statmentId) {
		this.statmentId = statmentId;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Integer getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(Integer scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Date getClockTime() {
		return this.clockTime;
	}

	public void setClockTime(Date clockTime) {
		this.clockTime = clockTime;
	}

	public Date getCompletedTime() {
		return this.completedTime;
	}

	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}

	public Date getSuspendTime() {
		return this.suspendTime;
	}

	public void setSuspendTime(Date suspendTime) {
		this.suspendTime = suspendTime;
	}

	public Date getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

}
