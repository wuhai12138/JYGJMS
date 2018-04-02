package com.summ.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("j_customer_feedback_department")
public class JCustomerFeedbackDepartment implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**  */
	private Integer feedbackId;

	/**  */
	private Integer department;

	public JCustomerFeedbackDepartment(Integer feedbackId, Integer department) {
		this.feedbackId = feedbackId;
		this.department = department;
	}

	public JCustomerFeedbackDepartment() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

}
