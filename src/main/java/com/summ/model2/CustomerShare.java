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
@TableName("customer_share")
public class CustomerShare implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/** 名称 */
	private String name;

	/**  */
	private Integer isDel;

	/**  */
	private Date createtime;

	/**  */
	private String address;

	/** 是否匹配地址 1匹配2不匹配 */
	private Integer sfaddress;

	/**  */
	private Integer shareid;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSfaddress() {
		return this.sfaddress;
	}

	public void setSfaddress(Integer sfaddress) {
		this.sfaddress = sfaddress;
	}

	public Integer getShareid() {
		return this.shareid;
	}

	public void setShareid(Integer shareid) {
		this.shareid = shareid;
	}

}
