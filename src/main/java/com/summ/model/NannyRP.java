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
@TableName("nanny_r_p")
public class NannyRP implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** id */
	@TableId(value = "rp_id", type = IdType.AUTO)
	private Integer rpId;

	/** 1奖励 2考勤 3赔偿 4其他(备注) 5订单取消 */
	@TableField(value = "rp_type")
	private Integer rpType;

	/** 奖励或惩罚的金额 */
	@TableField(value = "rp_money")
	private Double rpMoney;

	/** 创建人id */
	private Integer createid;

	/** 创建时间 */
	private Date createtime;

	/** 修改人id */
	private Integer modifyid;

	/** 修改时间 */
	private Date modifytime;

	/**  */
	private Integer isDel;

	/** 奖励或者惩罚备注 */
	@TableField(value = "rp_backup")
	private String rpBackup;

	/** 服务师id */
	@TableField(value = "rp_nanny_id")
	private Integer rpNannyId;


	public Integer getRpId() {
		return this.rpId;
	}

	public void setRpId(Integer rpId) {
		this.rpId = rpId;
	}

	public Integer getRpType() {
		return this.rpType;
	}

	public void setRpType(Integer rpType) {
		this.rpType = rpType;
	}

	public Double getRpMoney() {
		return this.rpMoney;
	}

	public void setRpMoney(Double rpMoney) {
		this.rpMoney = rpMoney;
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

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getRpBackup() {
		return this.rpBackup;
	}

	public void setRpBackup(String rpBackup) {
		this.rpBackup = rpBackup;
	}

	public Integer getRpNannyId() {
		return this.rpNannyId;
	}

	public void setRpNannyId(Integer rpNannyId) {
		this.rpNannyId = rpNannyId;
	}

}
