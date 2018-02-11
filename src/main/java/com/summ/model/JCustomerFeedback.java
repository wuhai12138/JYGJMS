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
@TableName("j_customer_feedback")
public class JCustomerFeedback implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 客户反馈表 */
	@TableId(type = IdType.AUTO)
	private Integer feedbackId;

	/**  */
	private String content;

	/** 客户 */
	private Integer customerId;

	/**  */
	private Date createDate = new Date();

	/** 处理部门id */
	private String department;

	/** 状态 */
	private Integer status=170;

	/** 记录人id */
	private Integer noteAdmin;

	/**  */
	private Integer isDel=16;


	public Integer getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getNoteAdmin() {
		return this.noteAdmin;
	}

	public void setNoteAdmin(Integer noteAdmin) {
		this.noteAdmin = noteAdmin;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
