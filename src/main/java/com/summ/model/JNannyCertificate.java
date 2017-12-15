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
@TableName("j_nanny_certificate")
public class JNannyCertificate implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 证件 */
	@TableId(type = IdType.AUTO)
	private Integer nannyCertId;

	/**  */
	private Integer nannyId;

	/**  */
	private String photo;

	/**  */
	private Integer certificateId;

	/**  */
	private Integer isDel;


	public Integer getNannyCertId() {
		return this.nannyCertId;
	}

	public void setNannyCertId(Integer nannyCertId) {
		this.nannyCertId = nannyCertId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getCertificateId() {
		return this.certificateId;
	}

	public void setCertificateId(Integer certificateId) {
		this.certificateId = certificateId;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
