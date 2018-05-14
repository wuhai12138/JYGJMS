package com.summ.model2;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *
 * 
 *
 */
public class Admin implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 管理员id */
	@TableId(value = "admin_id", type = IdType.AUTO)
	private Integer adminId;

	/** 管理员名称 */
	@TableField(value = "admin_name")
	private String adminName;

	/** 管理员电话 */
	@TableField(value = "admin_phone")
	private String adminPhone;

	/** 管理员类型1超级/2财务/3招聘/4培训中心/5门店/6客服 */
	@TableField(value = "admin_type")
	private Integer adminType;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;

	/** 创建时间 */
	private String createtime;

	/** 修改时间 */
	private String modifytime;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 归属0超管/1培训中心/2门店 */
	@TableField(value = "admin_belong")
	private Integer adminBelong;

	/** 门店id */
	@TableField(value = "shop_id")
	private Integer shopId;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;


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

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public Integer getAdminType() {
		return this.adminType;
	}

	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
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

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getAdminBelong() {
		return this.adminBelong;
	}

	public void setAdminBelong(Integer adminBelong) {
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

}
