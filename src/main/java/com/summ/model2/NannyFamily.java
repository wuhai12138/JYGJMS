package com.summ.model2;

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
@TableName("nanny_family")
public class NannyFamily implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 家庭信息id */
	@TableId(value = "family_id", type = IdType.AUTO)
	private Integer familyId;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 关系 */
	@TableField(value = "family_relationship")
	private String familyRelationship;

	/** 姓名 */
	@TableField(value = "family_name")
	private String familyName;

	/** 联系方式 */
	@TableField(value = "family_phone")
	private String familyPhone;

	/** 是否需要赡养父母 */
	@TableField(value = "family_parent")
	private String familyParent;

	/** 是否有子女 */
	@TableField(value = "family_child")
	private String familyChild;

	/** 人事留言 */
	@TableField(value = "family_hr")
	private String familyHr;

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


	public Integer getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public String getFamilyRelationship() {
		return this.familyRelationship;
	}

	public void setFamilyRelationship(String familyRelationship) {
		this.familyRelationship = familyRelationship;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyPhone() {
		return this.familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public String getFamilyParent() {
		return this.familyParent;
	}

	public void setFamilyParent(String familyParent) {
		this.familyParent = familyParent;
	}

	public String getFamilyChild() {
		return this.familyChild;
	}

	public void setFamilyChild(String familyChild) {
		this.familyChild = familyChild;
	}

	public String getFamilyHr() {
		return this.familyHr;
	}

	public void setFamilyHr(String familyHr) {
		this.familyHr = familyHr;
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

}
