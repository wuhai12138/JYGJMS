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
@TableName("j_schedule_nanny")
public class JScheduleNanny implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**  */
	private Integer scheduleId;

	/**  */
	private Integer nannyId;

	private Integer supplierId;

	/**  */
	private String assess="";

	/**  */
	private Integer staring=3;

	public JScheduleNanny(Integer scheduleId, Integer nannyId, Integer supplierId) {
		this.scheduleId = scheduleId;
		this.nannyId = nannyId;
		this.supplierId=supplierId;

	}

	public JScheduleNanny() {
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public String getAssess() {
		return this.assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	public Integer getStaring() {
		return this.staring;
	}

	public void setStaring(Integer staring) {
		this.staring = staring;
	}

}
