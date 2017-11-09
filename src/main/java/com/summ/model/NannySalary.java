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
@TableName("nanny_salary")
public class NannySalary implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "salary_id", type = IdType.AUTO)
	private Integer salaryId;

	/** 本月开始日期 */
	@TableField(value = "start_date")
	private Date startDate;

	/** 本月结束日期 */
	@TableField(value = "end_date")
	private Date endDate;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 一次性工时 */
	@TableField(value = "one_time")
	private Double oneTime;

	/** 免费工时 */
	@TableField(value = "free_time")
	private Double freeTime;

	/** 试工工时 */
	@TableField(value = "try_time")
	private Double tryTime;

	/** 包月工时 */
	@TableField(value = "month_time")
	private Double monthTime;

	/** 合同工时 */
	@TableField(value = "contract_time")
	private Double contractTime;

	/** 工时合计 */
	@TableField(value = "total_time")
	private Double totalTime;

	/** 薪酬合计 */
	@TableField(value = "total_price")
	private Double totalPrice;

	/** 0未删除1已删除 */
	private Integer isDel;

	/**  */
	private Integer createid;

	/**  */
	private Integer modifyid;

	/**  */
	private Date createtime;

	/**  */
	private Date modifytime;


	public Integer getSalaryId() {
		return this.salaryId;
	}

	public void setSalaryId(Integer salaryId) {
		this.salaryId = salaryId;
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

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
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

	public Double getFreeTime() {
		return this.freeTime;
	}

	public void setFreeTime(Double freeTime) {
		this.freeTime = freeTime;
	}

	public Double getTryTime() {
		return this.tryTime;
	}

	public void setTryTime(Double tryTime) {
		this.tryTime = tryTime;
	}

	public Double getMonthTime() {
		return this.monthTime;
	}

	public void setMonthTime(Double monthTime) {
		this.monthTime = monthTime;
	}

	public Double getContractTime() {
		return this.contractTime;
	}

	public void setContractTime(Double contractTime) {
		this.contractTime = contractTime;
	}

	public Double getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(Double totalTime) {
		this.totalTime = totalTime;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
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

}
