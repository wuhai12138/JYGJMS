package com.summ.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 提现方式
 *
 */
@TableName("shareholder_cash_way")
public class ShareholderCashWay implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "way_id", type = IdType.AUTO)
	private Integer wayId;

	/** 股东id */
	@TableField(value = "shareholder_id")
	private Integer shareholderId;

	/** 提现用户名称(持卡人) */
	@TableField(value = "way_name")
	private String wayName;

	/** 提现帐号(卡号/支付宝帐号/微信号) */
	@TableField(value = "way_account")
	private String wayAccount;

	/** 0 全部 1银行卡 2微信 3支付宝 */
	@TableField(value = "way_type")
	private Integer wayType;

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


	public Integer getWayId() {
		return this.wayId;
	}

	public void setWayId(Integer wayId) {
		this.wayId = wayId;
	}

	public Integer getShareholderId() {
		return this.shareholderId;
	}

	public void setShareholderId(Integer shareholderId) {
		this.shareholderId = shareholderId;
	}

	public String getWayName() {
		return this.wayName;
	}

	public void setWayName(String wayName) {
		this.wayName = wayName;
	}

	public String getWayAccount() {
		return this.wayAccount;
	}

	public void setWayAccount(String wayAccount) {
		this.wayAccount = wayAccount;
	}

	public Integer getWayType() {
		return this.wayType;
	}

	public void setWayType(Integer wayType) {
		this.wayType = wayType;
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
