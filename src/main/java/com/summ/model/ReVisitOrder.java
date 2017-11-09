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
@TableName("re_visit_order")
public class ReVisitOrder implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 回访订单ID */
	@TableId(type = IdType.AUTO)
	private Integer ReVisitId;

	/** 大订单ID */
	@TableField(value = "order_id")
	private Integer orderId;

	/** 房产id */
	@TableField(value = "house_id")
	private Integer houseId;

	/** 服务师ID */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 回访日期 */
	private Date ReVisitDate;

	/** 回访状态（0全部1未拜访2已拜访3已评价） */
	private Integer ReVisitStatus;

	/**  */
	private String Remark;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 创建人登录名 */
	private Integer createid;

	/** 修改人登录名 */
	private Integer modifyid;

	/** 是否删除(1为已删除) */
	private Integer isDel;

	/** 回访类型（0全部1整改2试工3两周4一月5稳定6换季7考核8二月） */
	private Integer VisitType;

	/** 评价星级（1，2，3，4，5） */
	private Integer Assess;

	/** 评价内容 */
	private String AssessContent;

	/**  */
	@TableField(value = "mission_id")
	private Integer missionId;


	public Integer getReVisitId() {
		return this.ReVisitId;
	}

	public void setReVisitId(Integer ReVisitId) {
		this.ReVisitId = ReVisitId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getHouseId() {
		return this.houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Date getReVisitDate() {
		return this.ReVisitDate;
	}

	public void setReVisitDate(Date ReVisitDate) {
		this.ReVisitDate = ReVisitDate;
	}

	public Integer getReVisitStatus() {
		return this.ReVisitStatus;
	}

	public void setReVisitStatus(Integer ReVisitStatus) {
		this.ReVisitStatus = ReVisitStatus;
	}

	public String getRemark() {
		return this.Remark;
	}

	public void setRemark(String Remark) {
		this.Remark = Remark;
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

	public Integer getVisitType() {
		return this.VisitType;
	}

	public void setVisitType(Integer VisitType) {
		this.VisitType = VisitType;
	}

	public Integer getAssess() {
		return this.Assess;
	}

	public void setAssess(Integer Assess) {
		this.Assess = Assess;
	}

	public String getAssessContent() {
		return this.AssessContent;
	}

	public void setAssessContent(String AssessContent) {
		this.AssessContent = AssessContent;
	}

	public Integer getMissionId() {
		return this.missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

}
