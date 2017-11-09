package com.summ.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("customer_service")
public class CustomerService implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "service_id", type = IdType.AUTO)
	private Integer serviceId;

	/** 客户id */
	@TableField(value = "customer_id")
	private Integer customerId;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 一次性工时 */
	@TableField(value = "one_time")
	private Double oneTime;

	/** 合同工时 */
	@TableField(value = "contract_time")
	private Double contractTime;

	/** 试工工时 */
	@TableField(value = "try_time")
	private Double tryTime;

	/** 免费工时 */
	@TableField(value = "free_time")
	private Double freeTime;

	/** 消费合计 */
	@TableField(value = "spend_total")
	private Double spendTotal;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;

	/** 0已删除1未删除 */
	private Integer isDel;

	/** 包月工时 */
	@TableField(value = "month_time")
	private Double monthTime;

	/** 本月开始日期 */
	@TableField(value = "start_date")
	private Date startDate;

	/** 本月结束日期 */
	@TableField(value = "end_date")
	private Date endDate;

	/** 工时合计 */
	@TableField(value = "total_time")
	private Double totalTime;


	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Double getOneTime() {
		return this.oneTime;
	}

	public void setOneTime(Double oneTime) {
		this.oneTime = oneTime;
	}

	public Double getContractTime() {
		return this.contractTime;
	}

	public void setContractTime(Double contractTime) {
		this.contractTime = contractTime;
	}

	public Double getTryTime() {
		return this.tryTime;
	}

	public void setTryTime(Double tryTime) {
		this.tryTime = tryTime;
	}

	public Double getFreeTime() {
		return this.freeTime;
	}

	public void setFreeTime(Double freeTime) {
		this.freeTime = freeTime;
	}

	public Double getSpendTotal() {
		return this.spendTotal;
	}

	public void setSpendTotal(Double spendTotal) {
		this.spendTotal = spendTotal;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getCreateid() {
		return this.createid;
	}

	public void setCreateid(Integer createid) {
		this.createid = createid;
	}

	public Integer getModifyid() {
		return this.modifyid;
	}

	public void setModifyid(Integer modifyid) {
		this.modifyid = modifyid;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Double getMonthTime() {
		return this.monthTime;
	}

	public void setMonthTime(Double monthTime) {
		this.monthTime = monthTime;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(Double totalTime) {
		this.totalTime = totalTime;
	}

}
