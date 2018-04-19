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
@TableName("j_withdrawal")
public class JWithdrawal implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 提现表 */
	@TableId(type = IdType.AUTO)
	private Integer withdrawalId;

	/**  */
	private Integer provinceId;
	/**  */
	private Integer cityId;
	/**  */
	private Integer areaId;
	/**  */
	private Integer streetId;
	/**  */
	private String withdrawalCard;
	/**  */
	private String withdrawalIdAddress;
	/** 申请人类别 */
	private Integer applyTpe;
	/** 申请人编号 */
	private Integer applyId;
	/**  */
	private String applyName;
	/**  */
	private String applyPhone;
	/**  */
	private Date applyDate;
	/**  */
	private Integer checkId;
	/**  */
	private Date checkDate;
	/**  */
	private Integer checkStatus;
	/**  */
	private String remark;
	/**  */
	private Integer isDel;


	public Integer getWithdrawalId() {
		return this.withdrawalId;
	}

	public void setWithdrawalId(Integer withdrawalId) {
		this.withdrawalId = withdrawalId;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getStreetId() {
		return this.streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}

	public String getWithdrawalCard() {
		return this.withdrawalCard;
	}

	public void setWithdrawalCard(String withdrawalCard) {
		this.withdrawalCard = withdrawalCard;
	}

	public String getWithdrawalIdAddress() {
		return this.withdrawalIdAddress;
	}

	public void setWithdrawalIdAddress(String withdrawalIdAddress) {
		this.withdrawalIdAddress = withdrawalIdAddress;
	}

	public Integer getApplyTpe() {
		return this.applyTpe;
	}

	public void setApplyTpe(Integer applyTpe) {
		this.applyTpe = applyTpe;
	}

	public Integer getApplyId() {
		return this.applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getApplyName() {
		return this.applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getApplyPhone() {
		return this.applyPhone;
	}

	public void setApplyPhone(String applyPhone) {
		this.applyPhone = applyPhone;
	}

	public Date getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
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

	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
}
