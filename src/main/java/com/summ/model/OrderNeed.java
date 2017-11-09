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
@TableName("order_need")
public class OrderNeed implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 订单需求id */
	@TableId(value = "need_id", type = IdType.AUTO)
	private Integer needId;

	/** 周几 */
	@TableField(value = "need_week")
	private Integer needWeek;

	/** 结束时间id */
	@TableField(value = "end_time")
	private Integer endTime;

	/** 备注 */
	@TableField(value = "need_back")
	private String needBack;

	/** 所需工时 */
	private Double needtime;

	/** 开始时间id */
	@TableField(value = "start_time")
	private Integer startTime;

	/** 所属大订单id */
	@TableField(value = "big_id")
	private Integer bigId;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;


	public Integer getNeedId() {
		return this.needId;
	}

	public void setNeedId(Integer needId) {
		this.needId = needId;
	}

	public Integer getNeedWeek() {
		return this.needWeek;
	}

	public void setNeedWeek(Integer needWeek) {
		this.needWeek = needWeek;
	}

	public Integer getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public String getNeedBack() {
		return this.needBack;
	}

	public void setNeedBack(String needBack) {
		this.needBack = needBack;
	}

	public Double getNeedtime() {
		return this.needtime;
	}

	public void setNeedtime(Double needtime) {
		this.needtime = needtime;
	}

	public Integer getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getBigId() {
		return this.bigId;
	}

	public void setBigId(Integer bigId) {
		this.bigId = bigId;
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

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
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

}
