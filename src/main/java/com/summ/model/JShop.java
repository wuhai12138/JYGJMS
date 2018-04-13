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
@TableName("j_shop")
public class JShop implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer shopId;

	/**  */
	private Integer trainId;

	/**  */
	private String shopName;

	/**  */
	private String shopPhone;

	/**  */
	private String shopAddress;

	/**  */
	private String shopPayCode;

	/**  */
	private String shopUrl;

	/**  */
	private double longitude;

	/**  */
	private double latitude;

	private Integer staring;

	/**  */
	private Integer isDel;

	/**  */
	private Date createTime;

	/**  */
	private Date modifyTime;

	private double distance;

	private String shopMobile;

	public double getDistance() {
		return distance;
	}


	public JShop(Integer shopId, String shopName) {
		this.shopId = shopId;
		this.shopName = shopName;
	}

	public JShop() {
	}

	public String getShopMobile() {
		return shopMobile;
	}

	public void setShopMobile(String shopMobile) {
		this.shopMobile = shopMobile;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Integer getStaring() {
		return staring;
	}

	public void setStaring(Integer staring) {
		this.staring = staring;
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

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopPhone() {
		return this.shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	public String getShopAddress() {
		return this.shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopPayCode() {
		return this.shopPayCode;
	}

	public void setShopPayCode(String shopPayCode) {
		this.shopPayCode = shopPayCode;
	}

	public String getShopUrl() {
		return this.shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
