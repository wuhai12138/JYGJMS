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
@TableName("customer_statement")
public class CustomerStatement implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键标识 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/** 余额 */
	private BigDecimal balance;

	/** 0全部1支出2充值3退款4红冲 */
	private Integer type;

	/** 发生订单时间 */
	private Date createtime;

	/** 点击完工时间 */
	private Date modifytime;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;

	/** 客户id */
	@TableField(value = "customer_id")
	private Integer customerId;

	/** 金额 */
	@TableField(value = "charge_money")
	private Double chargeMoney;

	/** 门店+微信+充值1000元+流水号123456789 */
	private String backup;

	/** 订单类型 */
	@TableField(value = "order_type")
	private Integer orderType;

	/** 工时 */
	@TableField(value = "mission_hour")
	private Double missionHour;

	/** 服务师名称 */
	@TableField(value = "nanny_name")
	private String nannyName;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private String nannyId;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Double getChargeMoney() {
		return this.chargeMoney;
	}

	public void setChargeMoney(Double chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	public String getBackup() {
		return this.backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Double getMissionHour() {
		return this.missionHour;
	}

	public void setMissionHour(Double missionHour) {
		this.missionHour = missionHour;
	}

	public String getNannyName() {
		return this.nannyName;
	}

	public void setNannyName(String nannyName) {
		this.nannyName = nannyName;
	}

	public String getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(String nannyId) {
		this.nannyId = nannyId;
	}

}
