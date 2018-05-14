package com.summ.model2;

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
@TableName("customer_account")
public class CustomerAccount implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/** 总支出 */
	@TableField(value = "all_out")
	private BigDecimal allOut;

	/** 总充值 */
	@TableField(value = "all_pay")
	private BigDecimal allPay;

	/** 当前余额 */
	private BigDecimal balance;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 客户id */
	@TableField(value = "customer_id")
	private Integer customerId;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;

	/** 总消费工时(只有支出的时候累加工时) */
	@TableField(value = "all_hour")
	private BigDecimal allHour;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAllOut() {
		return this.allOut;
	}

	public void setAllOut(BigDecimal allOut) {
		this.allOut = allOut;
	}

	public BigDecimal getAllPay() {
		return this.allPay;
	}

	public void setAllPay(BigDecimal allPay) {
		this.allPay = allPay;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public BigDecimal getAllHour() {
		return this.allHour;
	}

	public void setAllHour(BigDecimal allHour) {
		this.allHour = allHour;
	}

}
