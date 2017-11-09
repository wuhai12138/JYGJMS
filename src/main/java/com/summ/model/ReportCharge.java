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
@TableName("report_charge")
public class ReportCharge implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 充值id */
	@TableId(value = "charge_id", type = IdType.AUTO)
	private Integer chargeId;

	/** 客户id */
	@TableField(value = "customer_id")
	private Integer customerId;

	/** 金额 */
	@TableField(value = "charge_money")
	private BigDecimal chargeMoney;

	/** 充值方式(1支付宝/2微信/3银行卡/4现金/5其他) */
	@TableField(value = "charge_way")
	private Integer chargeWay;

	/** 流水号 */
	@TableField(value = "charge_no")
	private String chargeNo;

	/** 备注 */
	@TableField(value = "charge_backup")
	private String chargeBackup;

	/** 充值时间 */
	private Date createtime;

	/** 创建人登录名 */
	private Integer createid;

	/** 修改人登录名 */
	private Integer modifyid;

	/** 修改时间 */
	private Date modifytime;

	/** 是否删除(1为已删除) */
	private Integer isDel;

	/** 1后台2APP */
	@TableField(value = "charge_channel")
	private Integer chargeChannel;

	/** 门店id */
	@TableField(value = "shop_id")
	private Integer shopId;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;


	public Integer getChargeId() {
		return this.chargeId;
	}

	public void setChargeId(Integer chargeId) {
		this.chargeId = chargeId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getChargeMoney() {
		return this.chargeMoney;
	}

	public void setChargeMoney(BigDecimal chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	public Integer getChargeWay() {
		return this.chargeWay;
	}

	public void setChargeWay(Integer chargeWay) {
		this.chargeWay = chargeWay;
	}

	public String getChargeNo() {
		return this.chargeNo;
	}

	public void setChargeNo(String chargeNo) {
		this.chargeNo = chargeNo;
	}

	public String getChargeBackup() {
		return this.chargeBackup;
	}

	public void setChargeBackup(String chargeBackup) {
		this.chargeBackup = chargeBackup;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getChargeChannel() {
		return this.chargeChannel;
	}

	public void setChargeChannel(Integer chargeChannel) {
		this.chargeChannel = chargeChannel;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

}
