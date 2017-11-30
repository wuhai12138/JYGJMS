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
@TableName("j_customer_statment")
public class JCustomerStatment implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer statmentId;

	/**  */
	private Integer customerId;

	/**  */
	private Date chargeDate = new Date();

	/**  */
	private Integer statmentType;

	/**  */
	private Double chargeMoney;

	/**  */
	private Integer chargeWay;

	/**  */
	private Integer adminId;

	/**  */
	private Integer terminal;

	/**  */
	private Integer status;

	/** 余额 */
	private BigDecimal balance;

	/**  */
	private Integer serialNumber;

	/**  */
	private Integer isDel = 16;

	/**  */
	private String remark;


	public Integer getStatmentId() {
		return this.statmentId;
	}

	public void setStatmentId(Integer statmentId) {
		this.statmentId = statmentId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getChargeDate() {
		return this.chargeDate;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

	public Integer getStatmentType() {
		return this.statmentType;
	}

	public void setStatmentType(Integer statmentType) {
		this.statmentType = statmentType;
	}

	public Double getChargeMoney() {
		return this.chargeMoney;
	}

	public void setChargeMoney(Double chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	public Integer getChargeWay() {
		return this.chargeWay;
	}

	public void setChargeWay(Integer chargeWay) {
		this.chargeWay = chargeWay;
	}

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getTerminal() {
		return this.terminal;
	}

	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
