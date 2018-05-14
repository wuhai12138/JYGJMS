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
@TableName("order_small_nanny")
public class OrderSmallNanny implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 中间表id */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/** 小订单id */
	@TableField(value = "mission_id")
	private Integer missionId;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 客户id(用于 判断 服务师与 客户 是否为第一次合作) */
	@TableField(value = "customer_id")
	private Integer customerId;

	/** 服务等级1-5级(1级没有加成,从2级开始每一级加5块工资) */
	@TableField(value = "nanny_level")
	private Integer nannyLevel;

	/** 该服务师在该订单中的成本工资 */
	@TableField(value = "order_nanny_salary")
	private Double orderNannySalary;

	/** 签到状态 1未签到 2已签到 */
	private Integer sign;

	/** 签到时间 */
	private Date signtime;

	/**  */
	private String lat;

	/**  */
	private String lng;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMissionId() {
		return this.missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getNannyLevel() {
		return this.nannyLevel;
	}

	public void setNannyLevel(Integer nannyLevel) {
		this.nannyLevel = nannyLevel;
	}

	public Double getOrderNannySalary() {
		return this.orderNannySalary;
	}

	public void setOrderNannySalary(Double orderNannySalary) {
		this.orderNannySalary = orderNannySalary;
	}

	public Integer getSign() {
		return this.sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

	public Date getSigntime() {
		return this.signtime;
	}

	public void setSigntime(Date signtime) {
		this.signtime = signtime;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return this.lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

}
