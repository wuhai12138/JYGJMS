package com.summ.model2;

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
@TableName("report_red")
public class ReportRed implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "red_id", type = IdType.AUTO)
	private Integer redId;

	/** 日期 */
	private Date date;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 门店id */
	@TableField(value = "shop_id")
	private Integer shopId;

	/** 红冲金额 */
	@TableField(value = "red_money")
	private Double redMoney;

	/** 红冲原因1充值错误(减钱)/2退回账户(加钱)/3提现(减钱) */
	@TableField(value = "red_reason")
	private Integer redReason;

	/** 状态0全部1待处理2待退款3已处理4驳回 */
	@TableField(value = "red_status")
	private Integer redStatus;

	/** 备注 */
	@TableField(value = "red_backup")
	private String redBackup;

	/** 创建日期 */
	private Date createtime;

	/** 修改日期 */
	private Date modifytime;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 客户id */
	@TableField(value = "customer_id")
	private Integer customerId;

	/** 充值记录id */
	@TableField(value = "charge_id")
	private Integer chargeId;

	/**  */
	@TableField(value = "mission_id")
	private Integer missionId;


	public Integer getRedId() {
		return this.redId;
	}

	public void setRedId(Integer redId) {
		this.redId = redId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Double getRedMoney() {
		return this.redMoney;
	}

	public void setRedMoney(Double redMoney) {
		this.redMoney = redMoney;
	}

	public Integer getRedReason() {
		return this.redReason;
	}

	public void setRedReason(Integer redReason) {
		this.redReason = redReason;
	}

	public Integer getRedStatus() {
		return this.redStatus;
	}

	public void setRedStatus(Integer redStatus) {
		this.redStatus = redStatus;
	}

	public String getRedBackup() {
		return this.redBackup;
	}

	public void setRedBackup(String redBackup) {
		this.redBackup = redBackup;
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

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getChargeId() {
		return this.chargeId;
	}

	public void setChargeId(Integer chargeId) {
		this.chargeId = chargeId;
	}

	public Integer getMissionId() {
		return this.missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

}
