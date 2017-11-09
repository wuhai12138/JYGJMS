package com.summ.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *
 * 
 *
 */
public class Visit implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer visitid;

	/**  */
	private Integer customerid;

	/**  */
	private Integer missionid;

	/** 1未回访2已回访 */
	private Integer isvisit;

	/**  */
	private String visitbackup;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 是否删除(1为已删除) */
	private Integer isdel;

	/** 创建人登录名 */
	private Integer createid;

	/** 修改人登录名 */
	private Integer modifyid;

	/** 大订单id */
	private Integer orderid;


	public Integer getVisitid() {
		return this.visitid;
	}

	public void setVisitid(Integer visitid) {
		this.visitid = visitid;
	}

	public Integer getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Integer getMissionid() {
		return this.missionid;
	}

	public void setMissionid(Integer missionid) {
		this.missionid = missionid;
	}

	public Integer getIsvisit() {
		return this.isvisit;
	}

	public void setIsvisit(Integer isvisit) {
		this.isvisit = isvisit;
	}

	public String getVisitbackup() {
		return this.visitbackup;
	}

	public void setVisitbackup(String visitbackup) {
		this.visitbackup = visitbackup;
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

	public Integer getIsdel() {
		return this.isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
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

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

}
