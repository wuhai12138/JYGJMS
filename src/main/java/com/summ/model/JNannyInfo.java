package com.summ.model;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("j_nanny_info")
public class JNannyInfo implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer nannyId;

	/** 头像 */
	private String nannyAvatar;

	/** 服务师姓名 */
	private String nannyName;

	/**  */
	private Integer nannySex;

	/**  */
	private Integer nannyStatus = 55;

	/**  */
	private Integer nannyType;

	/** 3星4星5星 */
	private Integer nannyLevel =3;

	/**  */
	private String nannyPhone;

	/**  */
	private Integer provinceId;

	/**  */
	private Integer cityId;

	/**  */
	private Integer areaId;

	private Integer streetId;

	/**  */
	private String nannyAddress;

	/**  */
	private String nannyIdCard;

	/**  */
	private String nannyBirthday;

	/**  */
	private Integer nannyAge;

	/** 属相 */
	private Integer nannyAnimalSign;

	/**  */
	private Integer nannyNation;

	private Integer nannyOrigin;

	private Integer nannyEducation;

	/**  */
	private String nannyHeight;

	/**  */
	private String nannyWeight;

	/** 开户行 */
	private String salaryBank;

	/** 工资卡 */
	private Integer salaryCard;

	/** 期望薪资 */
	private BigDecimal expectSalary;

	/** 中介费 */
	private String nannyAgencyFees;

	/** 支付方式 */
	private int payment;

	/** 有效期 */
	private Date validDate;

	/**  */
	private String remark;

	/**  */
	private Date createTime;

	/**  */
	private Date modifyTime = new Date();

	/**  */
	private Integer isDel =16;






	public JNannyInfo() {
	}

	public JNannyInfo(Integer nannyId, String nannyAvatar) {
		this.nannyId = nannyId;
		this.nannyAvatar = nannyAvatar;
	}

	@Override
	public String toString() {
		return "JNannyInfo{" +
				"nannyId=" + nannyId +
				", nannyAvatar='" + nannyAvatar + '\'' +
				", nannyName='" + nannyName + '\'' +
				", nannySex=" + nannySex +
				", nannyStatus=" + nannyStatus +
				", nannyType=" + nannyType +
				", nannyLevel=" + nannyLevel +
				", nannyPhone='" + nannyPhone + '\'' +
				", provinceId=" + provinceId +
				", cityId=" + cityId +
				", areaId=" + areaId +
				", streetId=" + streetId +
				", nannyAddress='" + nannyAddress + '\'' +
				", nannyIdCard='" + nannyIdCard + '\'' +
				", nannyBirthday='" + nannyBirthday + '\'' +
				", nannyAge=" + nannyAge +
				", nannyAnimalSign=" + nannyAnimalSign +
				", nannyNation=" + nannyNation +
				", nannyOrigin=" + nannyOrigin +
				", nannyEducation=" + nannyEducation +
				", nannyHeight='" + nannyHeight + '\'' +
				", nannyWeight='" + nannyWeight + '\'' +
				", salaryBank='" + salaryBank + '\'' +
				", salaryCard=" + salaryCard +
				", expectSalary=" + expectSalary +
				", nannyAgencyFees='" + nannyAgencyFees + '\'' +
				", payment=" + payment +
				", validDate=" + validDate +
				", remark='" + remark + '\'' +
				", createTime=" + createTime +
				", modifyTime=" + modifyTime +
				", isDel=" + isDel +
				'}';
	}

	public Integer getNannyEducation() {
		return nannyEducation;
	}

	public void setNannyEducation(Integer nannyEducation) {
		this.nannyEducation = nannyEducation;
	}

	public Integer getStreetId() {
		return streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}

	public String getNannyAgencyFees() {
		return nannyAgencyFees;
	}

	public void setNannyAgencyFees(String nannyAgencyFees) {
		this.nannyAgencyFees = nannyAgencyFees;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public String getNannyAvatar() {
		return this.nannyAvatar;
	}

	public void setNannyAvatar(String nannyAvatar) {
		this.nannyAvatar = nannyAvatar;
	}

	public String getNannyName() {
		return this.nannyName;
	}

	public void setNannyName(String nannyName) {
		this.nannyName = nannyName;
	}

	public Integer getNannySex() {
		return this.nannySex;
	}

	public void setNannySex(Integer nannySex) {
		this.nannySex = nannySex;
	}

	public Integer getNannyStatus() {
		return this.nannyStatus;
	}

	public void setNannyStatus(Integer nannyStatus) {
		this.nannyStatus = nannyStatus;
	}

	public Integer getNannyType() {
		return this.nannyType;
	}

	public void setNannyType(Integer nannyType) {
		this.nannyType = nannyType;
	}

	public Integer getNannyLevel() {
		return this.nannyLevel;
	}

	public void setNannyLevel(Integer nannyLevel) {
		this.nannyLevel = nannyLevel;
	}

	public String getNannyPhone() {
		return this.nannyPhone;
	}

	public void setNannyPhone(String nannyPhone) {
		this.nannyPhone = nannyPhone;
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

	public String getNannyAddress() {
		return this.nannyAddress;
	}

	public void setNannyAddress(String nannyAddress) {
		this.nannyAddress = nannyAddress;
	}

	public String getNannyIdCard() {
		return this.nannyIdCard;
	}

	public void setNannyIdCard(String nannyIdCard) {
		this.nannyIdCard = nannyIdCard;
	}

	public String getNannyBirthday() {
		return this.nannyBirthday;
	}

	public void setNannyBirthday(String nannyBirthday) {
		this.nannyBirthday = nannyBirthday;
	}

	public Integer getNannyAge() {
		return this.nannyAge;
	}

	public void setNannyAge(Integer nannyAge) {
		this.nannyAge = nannyAge;
	}

	public Integer getNannyAnimalSign() {
		return nannyAnimalSign;
	}

	public void setNannyAnimalSign(Integer nannyAnimalSign) {
		this.nannyAnimalSign = nannyAnimalSign;
	}

	public Integer getNannyNation() {
		return nannyNation;
	}

	public void setNannyNation(Integer nannyNation) {
		this.nannyNation = nannyNation;
	}

	public Integer getNannyOrigin() {
		return nannyOrigin;
	}

	public void setNannyOrigin(Integer nannyOrigin) {
		this.nannyOrigin = nannyOrigin;
	}

	public String getNannyHeight() {
		return this.nannyHeight;
	}

	public void setNannyHeight(String nannyHeight) {
		this.nannyHeight = nannyHeight;
	}

	public String getNannyWeight() {
		return this.nannyWeight;
	}

	public void setNannyWeight(String nannyWeight) {
		this.nannyWeight = nannyWeight;
	}

	public String getSalaryBank() {
		return this.salaryBank;
	}

	public void setSalaryBank(String salaryBank) {
		this.salaryBank = salaryBank;
	}

	public Integer getSalaryCard() {
		return this.salaryCard;
	}

	public void setSalaryCard(Integer salaryCard) {
		this.salaryCard = salaryCard;
	}

	public BigDecimal getExpectSalary() {
		return this.expectSalary;
	}

	public void setExpectSalary(BigDecimal expectSalary) {
		this.expectSalary = expectSalary;
	}

	public int getPayment() {
		return this.payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
