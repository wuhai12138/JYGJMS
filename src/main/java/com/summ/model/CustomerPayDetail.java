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
@TableName("customer_pay_detail")
public class CustomerPayDetail implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "pay_id", type = IdType.AUTO)
	private Integer payId;

	/** 小订单id */
	@TableField(value = "mission_id")
	private Integer missionId;

	/** 小订单日期 */
	@TableField(value = "mission_date")
	private Date missionDate;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 工时 */
	@TableField(value = "mission_hour")
	private Double missionHour;

	/** 价格 */
	@TableField(value = "mission_price")
	private Double missionPrice;

	/** 客户id */
	@TableField(value = "customer_id")
	private Integer customerId;

	/** 订单类型1合同订单2一次性订单3包月4免费 */
	@TableField(value = "mission_type")
	private Integer missionType;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;

	/** 0未删除1已删除 */
	private Integer isDel;


	public Integer getPayId() {
		return this.payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public Integer getMissionId() {
		return this.missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public Date getMissionDate() {
		return this.missionDate;
	}

	public void setMissionDate(Date missionDate) {
		this.missionDate = missionDate;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Double getMissionHour() {
		return this.missionHour;
	}

	public void setMissionHour(Double missionHour) {
		this.missionHour = missionHour;
	}

	public Double getMissionPrice() {
		return this.missionPrice;
	}

	public void setMissionPrice(Double missionPrice) {
		this.missionPrice = missionPrice;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getMissionType() {
		return this.missionType;
	}

	public void setMissionType(Integer missionType) {
		this.missionType = missionType;
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
