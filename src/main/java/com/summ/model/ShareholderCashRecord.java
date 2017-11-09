package com.summ.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 股东提现记录
 *
 */
@TableName("shareholder_cash_record")
public class ShareholderCashRecord implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "cash_id", type = IdType.AUTO)
	private Integer cashId;

	/** 提现方式(关联shareholad_cash_way) */
	@TableField(value = "cash_way")
	private Integer cashWay;

	/** 股东id */
	@TableField(value = "shareholder_id")
	private Integer shareholderId;

	/** 0全部 1申请中 2 申请通过 3已拒绝 */
	@TableField(value = "cash_status")
	private Integer cashStatus;

	/** 提现金额 */
	@TableField(value = "cash_money")
	private Double cashMoney;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 创建人登录名 */
	private Integer createid;

	/** 修改人登录名 */
	private Integer modifyid;

	/** 是否删除(1为已删除) */
	private Integer isDel;


	public Integer getCashId() {
		return this.cashId;
	}

	public void setCashId(Integer cashId) {
		this.cashId = cashId;
	}

	public Integer getCashWay() {
		return this.cashWay;
	}

	public void setCashWay(Integer cashWay) {
		this.cashWay = cashWay;
	}

	public Integer getShareholderId() {
		return this.shareholderId;
	}

	public void setShareholderId(Integer shareholderId) {
		this.shareholderId = shareholderId;
	}

	public Integer getCashStatus() {
		return this.cashStatus;
	}

	public void setCashStatus(Integer cashStatus) {
		this.cashStatus = cashStatus;
	}

	public Double getCashMoney() {
		return this.cashMoney;
	}

	public void setCashMoney(Double cashMoney) {
		this.cashMoney = cashMoney;
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

}
