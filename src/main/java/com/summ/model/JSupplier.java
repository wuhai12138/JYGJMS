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
@TableName("j_supplier")
public class JSupplier implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 供应商Id */
	@TableId(type = IdType.AUTO)
	private Integer supplierId;

	/** 公司名称 */
	private String name;

	/**  */
	private String address;

	/** 手机号 */
	private String phone;

	/** 联系人 */
	private String contect;

	/**  */
	private Integer supplierStatus=182;

	/**  */
	private String contacter;

	/**  */
	private Integer provinceId=1;

	/**  */
	private Integer cityId=1;

	/**  */
	private Integer areaId;

	/**  */
	private String remark="";

	/** 公司注册地址 */
	private String registerAddress;

	/** 统一社会信用代码 */
	private String creditCode;

	/** 经营范围 */
	private String businessScope;
	/**经营期限*/
	private Date businessStartDate;
	private Date businessEndDate;

	/** 法人 */
	private String legalPerson;

	/**  */
	private String idCard;

	/** 身份证有效期 */
	private Date idValidDate;

	/** 开户行 */
	private String depositBank;

	/** 银行账号 */
	private String bankAccount;

	/** 营业执照 图片 */
	private String businessLicense;

	/** 身份证正面照 */
	private String idCardBefore;

	/** 身份证反面照 */
	private String idCardAfter;

	/**  */
	private Date createTime=new Date();

	/**  */
	private Integer isDel=16;

	public Date getBusinessStartDate() {
		return businessStartDate;
	}

	public void setBusinessStartDate(Date businessStartDate) {
		this.businessStartDate = businessStartDate;
	}

	public Date getBusinessEndDate() {
		return businessEndDate;
	}

	public void setBusinessEndDate(Date businessEndDate) {
		this.businessEndDate = businessEndDate;
	}

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContect() {
		return this.contect;
	}

	public void setContect(String contect) {
		this.contect = contect;
	}

	public Integer getSupplierStatus() {
		return this.supplierStatus;
	}

	public void setSupplierStatus(Integer supplierStatus) {
		this.supplierStatus = supplierStatus;
	}

	public String getContacter() {
		return this.contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRegisterAddress() {
		return this.registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	public String getCreditCode() {
		return this.creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getBusinessScope() {
		return this.businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getLegalPerson() {
		return this.legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getIdValidDate() {
		return this.idValidDate;
	}

	public void setIdValidDate(Date idValidDate) {
		this.idValidDate = idValidDate;
	}

	public String getDepositBank() {
		return this.depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBusinessLicense() {
		return this.businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getIdCardBefore() {
		return this.idCardBefore;
	}

	public void setIdCardBefore(String idCardBefore) {
		this.idCardBefore = idCardBefore;
	}

	public String getIdCardAfter() {
		return this.idCardAfter;
	}

	public void setIdCardAfter(String idCardAfter) {
		this.idCardAfter = idCardAfter;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
