package com.summ.model2;

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
@TableName("nanny_info")
public class NannyInfo implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 服务师id */
	@TableId(value = "nanny_id", type = IdType.AUTO)
	private Integer nannyId;

	/** 服务师姓名 */
	@TableField(value = "nanny_name")
	private String nannyName;

	/** 性别1男2女0全部 */
	@TableField(value = "nanny_sex")
	private Integer nannySex;

	/** 手机号码 */
	@TableField(value = "nanny_phone")
	private String nannyPhone;

	/** 现住地址 */
	@TableField(value = "nanny_address")
	private String nannyAddress;

	/** 生日 */
	@TableField(value = "nanny_birthday")
	private Date nannyBirthday;

	/** 工作年限 */
	@TableField(value = "nanny_year")
	private Integer nannyYear;

	/** 籍贯 */
	@TableField(value = "nanny_root")
	private String nannyRoot;

	/** 民族 */
	@TableField(value = "nanny_nation")
	private String nannyNation;

	/** 属相 */
	@TableField(value = "nanny_zodiac")
	private String nannyZodiac;

	/** 语言 */
	@TableField(value = "nanny_language")
	private String nannyLanguage;

	/** 身高 */
	@TableField(value = "nanny_height")
	private String nannyHeight;

	/** 体重 */
	@TableField(value = "nanny_weight")
	private String nannyWeight;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 状态(1预录/2培训成功/3离职/4黑名单) */
	@TableField(value = "nanny_status")
	private Integer nannyStatus;

	/** 服务等级 */
	@TableField(value = "nanny_level")
	private Integer nannyLevel;

	/** 工作类型2白班服务师4住家保姆6育儿嫂19月嫂91外包 */
	@TableField(value = "nanny_type")
	private Integer nannyType;

	/** 学历 */
	@TableField(value = "nanny_qualification")
	private String nannyQualification;

	/** 证书 */
	@TableField(value = "nanny_certificate")
	private String nannyCertificate;

	/** 身份证号码 */
	@TableField(value = "nanny_id_card")
	private String nannyIdCard;

	/** 身份证地址 */
	@TableField(value = "nanny_id_address")
	private String nannyIdAddress;

	/** 经验介绍 */
	@TableField(value = "nanny_exp")
	private String nannyExp;

	/** 特长(若特长为下拉选项,可考虑添加到数据字典表中,是否会作为筛选条件) */
	@TableField(value = "nanny_skill")
	private String nannySkill;

	/** 性格特点 */
	@TableField(value = "nanny_character")
	private String nannyCharacter;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 备注 */
	private String remark;

	/** 创建人登录名 */
	private Integer createid;

	/** 修改人登录名 */
	private Integer modifyid;

	/** 是否删除(1为已删除) */
	private Integer isDel;

	/** 头像 */
	@TableField(value = "nanny_head")
	private String nannyHead;

	/** 服务师正面照片 */
	@TableField(value = "nanny_card_front")
	private String nannyCardFront;

	/** 服务师反面照片 */
	@TableField(value = "nanny_card_reverse")
	private String nannyCardReverse;

	/** 宗教 */
	@TableField(value = "nanny_religion")
	private String nannyReligion;

	/** 期望薪资 */
	@TableField(value = "expect_salary")
	private BigDecimal expectSalary;

	/**  */
	private Date startdate;

	/** 1未审核2已审核 */
	private Integer hrcheck;

	/** 开户行 */
	private String bank;

	/** 银行卡号 */
	private String bankno;

	/** 1未买断2买断 */
	private Integer buyhour;

	/** 买断时间 */
	private Date buytime;


	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
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

	public String getNannyPhone() {
		return this.nannyPhone;
	}

	public void setNannyPhone(String nannyPhone) {
		this.nannyPhone = nannyPhone;
	}

	public String getNannyAddress() {
		return this.nannyAddress;
	}

	public void setNannyAddress(String nannyAddress) {
		this.nannyAddress = nannyAddress;
	}

	public Date getNannyBirthday() {
		return this.nannyBirthday;
	}

	public void setNannyBirthday(Date nannyBirthday) {
		this.nannyBirthday = nannyBirthday;
	}

	public Integer getNannyYear() {
		return this.nannyYear;
	}

	public void setNannyYear(Integer nannyYear) {
		this.nannyYear = nannyYear;
	}

	public String getNannyRoot() {
		return this.nannyRoot;
	}

	public void setNannyRoot(String nannyRoot) {
		this.nannyRoot = nannyRoot;
	}

	public String getNannyNation() {
		return this.nannyNation;
	}

	public void setNannyNation(String nannyNation) {
		this.nannyNation = nannyNation;
	}

	public String getNannyZodiac() {
		return this.nannyZodiac;
	}

	public void setNannyZodiac(String nannyZodiac) {
		this.nannyZodiac = nannyZodiac;
	}

	public String getNannyLanguage() {
		return this.nannyLanguage;
	}

	public void setNannyLanguage(String nannyLanguage) {
		this.nannyLanguage = nannyLanguage;
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

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Integer getNannyStatus() {
		return this.nannyStatus;
	}

	public void setNannyStatus(Integer nannyStatus) {
		this.nannyStatus = nannyStatus;
	}

	public Integer getNannyLevel() {
		return this.nannyLevel;
	}

	public void setNannyLevel(Integer nannyLevel) {
		this.nannyLevel = nannyLevel;
	}

	public Integer getNannyType() {
		return this.nannyType;
	}

	public void setNannyType(Integer nannyType) {
		this.nannyType = nannyType;
	}

	public String getNannyQualification() {
		return this.nannyQualification;
	}

	public void setNannyQualification(String nannyQualification) {
		this.nannyQualification = nannyQualification;
	}

	public String getNannyCertificate() {
		return this.nannyCertificate;
	}

	public void setNannyCertificate(String nannyCertificate) {
		this.nannyCertificate = nannyCertificate;
	}

	public String getNannyIdCard() {
		return this.nannyIdCard;
	}

	public void setNannyIdCard(String nannyIdCard) {
		this.nannyIdCard = nannyIdCard;
	}

	public String getNannyIdAddress() {
		return this.nannyIdAddress;
	}

	public void setNannyIdAddress(String nannyIdAddress) {
		this.nannyIdAddress = nannyIdAddress;
	}

	public String getNannyExp() {
		return this.nannyExp;
	}

	public void setNannyExp(String nannyExp) {
		this.nannyExp = nannyExp;
	}

	public String getNannySkill() {
		return this.nannySkill;
	}

	public void setNannySkill(String nannySkill) {
		this.nannySkill = nannySkill;
	}

	public String getNannyCharacter() {
		return this.nannyCharacter;
	}

	public void setNannyCharacter(String nannyCharacter) {
		this.nannyCharacter = nannyCharacter;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getNannyHead() {
		return this.nannyHead;
	}

	public void setNannyHead(String nannyHead) {
		this.nannyHead = nannyHead;
	}

	public String getNannyCardFront() {
		return this.nannyCardFront;
	}

	public void setNannyCardFront(String nannyCardFront) {
		this.nannyCardFront = nannyCardFront;
	}

	public String getNannyCardReverse() {
		return this.nannyCardReverse;
	}

	public void setNannyCardReverse(String nannyCardReverse) {
		this.nannyCardReverse = nannyCardReverse;
	}

	public String getNannyReligion() {
		return this.nannyReligion;
	}

	public void setNannyReligion(String nannyReligion) {
		this.nannyReligion = nannyReligion;
	}

	public BigDecimal getExpectSalary() {
		return this.expectSalary;
	}

	public void setExpectSalary(BigDecimal expectSalary) {
		this.expectSalary = expectSalary;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Integer getHrcheck() {
		return this.hrcheck;
	}

	public void setHrcheck(Integer hrcheck) {
		this.hrcheck = hrcheck;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankno() {
		return this.bankno;
	}

	public void setBankno(String bankno) {
		this.bankno = bankno;
	}

	public Integer getBuyhour() {
		return this.buyhour;
	}

	public void setBuyhour(Integer buyhour) {
		this.buyhour = buyhour;
	}

	public Date getBuytime() {
		return this.buytime;
	}

	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}

}
