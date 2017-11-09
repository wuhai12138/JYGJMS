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
@TableName("nanny_leave")
public class NannyLeave implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 请假单id */
	@TableId(value = "leave_id", type = IdType.AUTO)
	private Integer leaveId;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 开始时间 */
	@TableField(value = "start_date")
	private Date startDate;

	/** 结束时间 */
	@TableField(value = "end_date")
	private Date endDate;

	/** 创建人登录名 */
	private Integer createid;

	/** 修改人登录名 */
	private Integer modifyid;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 是否删除(1为已删除) */
	private Integer isDel;

	/** 备注信息 */
	private String backup;

	/** 1申请中2已通过3已拒绝 */
	@TableField(value = "leave_status")
	private Integer leaveStatus;


	public Integer getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public String getBackup() {
		return this.backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

	public Integer getLeaveStatus() {
		return this.leaveStatus;
	}

	public void setLeaveStatus(Integer leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

}
