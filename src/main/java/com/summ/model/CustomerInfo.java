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
@TableName("customer_info")
public class CustomerInfo implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 客户id */
	@TableId(value = "customer_id", type = IdType.AUTO)
	private Integer customerId;

	/** 真实姓名 */
	@TableField(value = "customer_name")
	private String customerName;

	/** 用户手机号码 */
	@TableField(value = "customer_phone")
	private String customerPhone;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 用户类型1注册2会员3僵尸用户 */
	@TableField(value = "customer_type")
	private Integer customerType;

	/** 创建人登录名 */
	private Integer createid;

	/** 修改人登录名 */
	private Integer modifyid;

	/** 是否删除(1为已删除) */
	private Integer isDel;

	/** 1男2女 */
	@TableField(value = "customer_sex")
	private Integer customerSex;

	/** 所属门店id */
	@TableField(value = "shop_id")
	private Integer shopId;

	/** 余额 */
	@TableField(value = "customer_balance")
	private BigDecimal customerBalance;

	/** 1警告2不警告 */
	@TableField(value = "warm_type")
	private Integer warmType;

	/** 备注 */
	private String backup;


	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
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

	public Integer getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
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

	public Integer getCustomerSex() {
		return this.customerSex;
	}

	public void setCustomerSex(Integer customerSex) {
		this.customerSex = customerSex;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public BigDecimal getCustomerBalance() {
		return this.customerBalance;
	}

	public void setCustomerBalance(BigDecimal customerBalance) {
		this.customerBalance = customerBalance;
	}

	public Integer getWarmType() {
		return this.warmType;
	}

	public void setWarmType(Integer warmType) {
		this.warmType = warmType;
	}

	public String getBackup() {
		return this.backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

}
