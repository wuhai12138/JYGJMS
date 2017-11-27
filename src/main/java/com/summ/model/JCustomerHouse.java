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
@TableName("j_customer_house")
public class JCustomerHouse implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer houseId;

	/**  */
	private Integer customerId;

	/**  */
	private Integer provinceId = 1;

	/**  */
	private Integer cityId = 1;

	/**  */
	private Integer areaId;

	/** 房产地址 */
	private String houseAddress;

	/**  */
	private Integer bedRoom;

	/**  */
	private Integer livingRoom;

	/**  */
	private Integer restRoom;

	/** 面积 */
	private String houseArea;

	/**  */
	private Date createTime = new Date();

	/**  */
	private Integer isDel = 16;


	public Integer getHouseId() {
		return this.houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getHouseAddress() {
		return this.houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public Integer getBedRoom() {
		return this.bedRoom;
	}

	public void setBedRoom(Integer bedRoom) {
		this.bedRoom = bedRoom;
	}

	public Integer getLivingRoom() {
		return this.livingRoom;
	}

	public void setLivingRoom(Integer livingRoom) {
		this.livingRoom = livingRoom;
	}

	public Integer getRestRoom() {
		return this.restRoom;
	}

	public void setRestRoom(Integer restRoom) {
		this.restRoom = restRoom;
	}

	public String getHouseArea() {
		return this.houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
