package com.summ.model2;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *
 * 
 *
 */
public class Coupon implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.INPUT)
	private Integer couponid;

	/** 优惠券名字 */
	private String couponname;

	/** 优惠券说明 */
	private String coupondetail;

	/** 是否删除(1为已删除) */
	private Integer isdel;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/**  */
	private Integer coupontype;

	/**  */
	private BigDecimal couponprice;

	/**  */
	private BigDecimal couponcost;


	public Integer getCouponid() {
		return this.couponid;
	}

	public void setCouponid(Integer couponid) {
		this.couponid = couponid;
	}

	public String getCouponname() {
		return this.couponname;
	}

	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}

	public String getCoupondetail() {
		return this.coupondetail;
	}

	public void setCoupondetail(String coupondetail) {
		this.coupondetail = coupondetail;
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

	public Integer getCoupontype() {
		return this.coupontype;
	}

	public void setCoupontype(Integer coupontype) {
		this.coupontype = coupontype;
	}

	public BigDecimal getCouponprice() {
		return this.couponprice;
	}

	public void setCouponprice(BigDecimal couponprice) {
		this.couponprice = couponprice;
	}

	public BigDecimal getCouponcost() {
		return this.couponcost;
	}

	public void setCouponcost(BigDecimal couponcost) {
		this.couponcost = couponcost;
	}

}
