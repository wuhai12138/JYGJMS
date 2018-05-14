package com.summ.model2.response;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 
 *
 */
@TableName("customer_house")
public class CustomerHouseRes implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 房子地址id */
	@TableId(value = "house_id", type = IdType.AUTO)
	private Integer houseId;

	/** 客户id */
	@TableField(value = "customer_id")
	private Integer customerId;
	/** 所属门店id */
	@TableField(value = "shop_id")
	private Integer shopId;

	/** 房产地址 */
	@TableField(value = "house_address")
	private String houseAddress;

	/** 类型 */
	@TableField(value = "room_type")
	private String roomType;

	/** 面积 */
	@TableField(value = "house_area")
	private String houseArea;

	/** 创建人登录名 */
	private Integer createid;

	/** 修改人登录名 */
	private Integer modifyid;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 是否删除(1为已删除) */
	private Integer isDel;

	/** 经度 */
	private String longitude;

	/** 纬度 */
	private String latitude;

	/** 分成  关联customer_share表 */
	private Integer share;

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

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

	public String getHouseAddress() {
		return this.houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getHouseArea() {
		return this.houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
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

	public Integer getShare() {
		return this.share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

}
