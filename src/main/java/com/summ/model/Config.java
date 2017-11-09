package com.summ.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *
 * 
 *
 */
public class Config implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** ios推送false开发环境true生产环境 */
	private Integer push;

	/**  */
	@TableId(type = IdType.AUTO)
	private Long id;


	public Integer getPush() {
		return this.push;
	}

	public void setPush(Integer push) {
		this.push = push;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
