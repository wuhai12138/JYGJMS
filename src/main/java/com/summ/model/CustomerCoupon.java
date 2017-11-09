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
@TableName("customer_coupon")
public class CustomerCoupon implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**  */
	private Integer customerid;

	/**  */
	private Integer couponid;

	/** 1未使用2已使用3未激活 */
	private Integer couponstatus;

	/** 是否删除(1为已删除) */
	private Integer isdel;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 小订单id */
	private Integer missionid;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Integer getCouponid() {
		return this.couponid;
	}

	public void setCouponid(Integer couponid) {
		this.couponid = couponid;
	}

	public Integer getCouponstatus() {
		return this.couponstatus;
	}

	public void setCouponstatus(Integer couponstatus) {
		this.couponstatus = couponstatus;
	}

	public Integer getIsdel() {
		return this.isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
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

	public Integer getMissionid() {
		return this.missionid;
	}

	public void setMissionid(Integer missionid) {
		this.missionid = missionid;
	}

}
