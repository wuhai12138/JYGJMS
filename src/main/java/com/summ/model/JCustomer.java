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
@TableName("j_customer")
public class JCustomer implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer customerId;

	/**  */
	private Integer shopId;

	/**  */
	private String customerName;

	/**  */
	private String customerPhone;

	/** 用户类型1注册2会员3僵尸用户 */
	private Integer customerType;

	/** 1男2女 */
	private Integer customerSex;

	/**  */
	private BigDecimal customerBalance;

	/** 1警告2不警告 */
	private Integer warnType;

	/**  */
	private String remark;

	/**  */
	private Date createTime;

	/** 是否删除（1为已删除） */
	private Integer isDel;

	/** 1门店2电话咨询3ios4android */
	private String memberOrigin;

	/**  */
	private Integer memberLevel;

	/**  */
	private Integer memberType;

	/**  */
	private String fieldParam4;


	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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

	public Integer getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}

	public Integer getCustomerSex() {
		return this.customerSex;
	}

	public void setCustomerSex(Integer customerSex) {
		this.customerSex = customerSex;
	}

	public BigDecimal getCustomerBalance() {
		return this.customerBalance;
	}

	public void setCustomerBalance(BigDecimal customerBalance) {
		this.customerBalance = customerBalance;
	}

	public Integer getWarnType() {
		return this.warnType;
	}

	public void setWarnType(Integer warnType) {
		this.warnType = warnType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getMemberOrigin() {
		return this.memberOrigin;
	}

	public void setMemberOrigin(String memberOrigin) {
		this.memberOrigin = memberOrigin;
	}

	public Integer getMemberLevel() {
		return this.memberLevel;
	}

	public void setMemberLevel(Integer memberLevel) {
		this.memberLevel = memberLevel;
	}

	public Integer getMemberType() {
		return this.memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	public String getFieldParam4() {
		return this.fieldParam4;
	}

	public void setFieldParam4(String fieldParam4) {
		this.fieldParam4 = fieldParam4;
	}

}
