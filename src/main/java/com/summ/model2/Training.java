package com.summ.model2;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *
 * 
 *
 */
public class Training implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 培训中心id */
	@TableId(value = "train_id", type = IdType.AUTO)
	private Integer trainId;

	/** 培训中心名称 */
	@TableField(value = "train_name")
	private String trainName;

	/** 联系电话 */
	@TableField(value = "train_phone")
	private String trainPhone;

	/** 地址 */
	@TableField(value = "train_address")
	private String trainAddress;

	/** 基础成本单价 */
	private Double cost;

	/** 基础销售单价 */
	private Double price;

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

	/** 经度 */
	private String longitude;

	/** 纬度 */
	private String latitude;


	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return this.trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainPhone() {
		return this.trainPhone;
	}

	public void setTrainPhone(String trainPhone) {
		this.trainPhone = trainPhone;
	}

	public String getTrainAddress() {
		return this.trainAddress;
	}

	public void setTrainAddress(String trainAddress) {
		this.trainAddress = trainAddress;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
