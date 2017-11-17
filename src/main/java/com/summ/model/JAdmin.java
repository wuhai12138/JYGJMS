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
@TableName("j_admin")
public class JAdmin implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer adminId;

	/**  */
	private String adminName;

	/**  */
	private String adminPhone;

	/** 管理员类型1超级/2财务/3招聘/4培训中心/5门店 */
	private String adminType;

	/** 归属0超管/1培训中心/2门店 */
	private String adminBelong;

	/**  */
	private Integer shopId;

	/**  */
	private Integer trainId;

	/**  */
	private Integer isDel;

	/**  */
	private Date createTime;

	/**  */
	private Date modifyTime;

	/**  */
	private Integer createId;

	/**  */
	private Integer modifyId;

	/**  */
	private String adminPassword;

	/**  */
	private String fieldParam2;

	/**  */
	private String fieldParam3;

	/**  */
	private String fieldParam4;


	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPhone() {
		return this.adminPhone;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminType() {
		return this.adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	public String getAdminBelong() {
		return this.adminBelong;
	}

	public void setAdminBelong(String adminBelong) {
		this.adminBelong = adminBelong;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getCreateId() {
		return this.createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Integer getModifyId() {
		return this.modifyId;
	}

	public void setModifyId(Integer modifyId) {
		this.modifyId = modifyId;
	}

	public String getFieldParam2() {
		return this.fieldParam2;
	}

	public void setFieldParam2(String fieldParam2) {
		this.fieldParam2 = fieldParam2;
	}

	public String getFieldParam3() {
		return this.fieldParam3;
	}

	public void setFieldParam3(String fieldParam3) {
		this.fieldParam3 = fieldParam3;
	}

	public String getFieldParam4() {
		return this.fieldParam4;
	}

	public void setFieldParam4(String fieldParam4) {
		this.fieldParam4 = fieldParam4;
	}

}
