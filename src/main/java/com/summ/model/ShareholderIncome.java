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
@TableName("shareholder_income")
public class ShareholderIncome implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 股东收益id */
	@TableId(value = "income_id", type = IdType.AUTO)
	private Integer incomeId;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 实际业务收入 */
	@TableField(value = "income_service")
	private Double incomeService;

	/** 支付工资 */
	private Double salary;

	/** 分享收入 */
	@TableField(value = "income_in")
	private Double incomeIn;

	/** 分享支出 */
	@TableField(value = "income_out")
	private Double incomeOut;

	/** 利润 */
	private Double income;

	/** 汇总 */
	@TableField(value = "income_count")
	private Double incomeCount;

	/** 是否删除 0未删除1已删除 */
	private Integer isDel;

	/** 创建人id */
	private Integer createid;

	/** 创建时间 */
	private Date createtime;

	/** 修改人id */
	private Integer modifyid;

	/** 修改时间 */
	private Date modifytime;

	/** 门店id */
	@TableField(value = "shop_id")
	private Integer shopId;


	public Integer getIncomeId() {
		return this.incomeId;
	}

	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Double getIncomeService() {
		return this.incomeService;
	}

	public void setIncomeService(Double incomeService) {
		this.incomeService = incomeService;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getIncomeIn() {
		return this.incomeIn;
	}

	public void setIncomeIn(Double incomeIn) {
		this.incomeIn = incomeIn;
	}

	public Double getIncomeOut() {
		return this.incomeOut;
	}

	public void setIncomeOut(Double incomeOut) {
		this.incomeOut = incomeOut;
	}

	public Double getIncome() {
		return this.income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getIncomeCount() {
		return this.incomeCount;
	}

	public void setIncomeCount(Double incomeCount) {
		this.incomeCount = incomeCount;
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

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getModifyid() {
		return this.modifyid;
	}

	public void setModifyid(Integer modifyid) {
		this.modifyid = modifyid;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}
