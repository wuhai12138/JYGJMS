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
@TableName("nanny_statement")
public class NannyStatement implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "statement_id", type = IdType.AUTO)
	private Integer statementId;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 订单工时 */
	@TableField(value = "mission_hour")
	private Double missionHour;

	/** 订单类型,1合同 2包月 3一次性 4免费 5试工 6包年 7奖励 8惩罚 */
	@TableField(value = "mission_type")
	private Integer missionType;

	/** 价格 */
	@TableField(value = "mission_cost")
	private BigDecimal missionCost;

	/** 是否删除 0未删除1已删除 */
	private Integer isDel;

	/** 创建人id */
	private Integer createid;

	/** 创建时间 */
	private Date createtime;

	/** 修改人id */
	private Integer modifyid;

	/** 修改时间 */
	private Date modifytime;

	/** 小订单id */
	@TableField(value = "mission_id")
	private Integer missionId;

	/**  */
	@TableField(value = "shop_id")
	private Integer shopId;

	/**  */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 备注 */
	private String backup;


	public Integer getStatementId() {
		return this.statementId;
	}

	public void setStatementId(Integer statementId) {
		this.statementId = statementId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public Double getMissionHour() {
		return this.missionHour;
	}

	public void setMissionHour(Double missionHour) {
		this.missionHour = missionHour;
	}

	public Integer getMissionType() {
		return this.missionType;
	}

	public void setMissionType(Integer missionType) {
		this.missionType = missionType;
	}

	public BigDecimal getMissionCost() {
		return this.missionCost;
	}

	public void setMissionCost(BigDecimal missionCost) {
		this.missionCost = missionCost;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getCreateid() {
		return this.createid;
	}

	public void setCreateid(Integer createid) {
		this.createid = createid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getModifyid() {
		return this.modifyid;
	}

	public void setModifyid(Integer modifyid) {
		this.modifyid = modifyid;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getMissionId() {
		return this.missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
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

	public String getBackup() {
		return this.backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

}
