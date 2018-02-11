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
@TableName("j_supplier")
public class JSupplier implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 供应商Id */
	@TableId(type = IdType.AUTO)
	private Integer supplierId;

	/**  */
	private String name;

	/**  */
	private String address;

	/**  */
	private String phone;

	/** 联系人 */
	private String contect;

	/**  */
	private Date createTime;

	/**  */
	private Integer isDel;


	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContect() {
		return this.contect;
	}

	public void setContect(String contect) {
		this.contect = contect;
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
