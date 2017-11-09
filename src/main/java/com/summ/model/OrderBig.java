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
@TableName("order_big")
public class OrderBig implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 订单id */
	@TableId(value = "order_id", type = IdType.AUTO)
	private Integer orderId;

	/** 订单开始时间 */
	@TableField(value = "order_start_date")
	private Date orderStartDate;

	/** 订单结束时间 */
	@TableField(value = "order_end_date")
	private Date orderEndDate;

	/** 0全部1合同2包月3一次性4免费5包年 */
	@TableField(value = "order_type")
	private Integer orderType;

	/** 1预约中/2未配单/3已配单(已删除此状态)/4试工中/5已开工/6已完工/7试工结束 */
	@TableField(value = "order_status")
	private Integer orderStatus;

	/** 备注 */
	private String backup;

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

	/** 房产id */
	@TableField(value = "house_id")
	private Integer houseId;

	/** 需求json */
	@TableField(value = "need_json")
	private String needJson;

	/** 单价 */
	private String price;

	/** 总价 */
	@TableField(value = "total_price")
	private String totalPrice;

	/** 门店id */
	@TableField(value = "shop_id")
	private Integer shopId;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 服务周期(只有选包月订单才有此选项,1=五休二,2=六休一,3=7天一周,不选传0) */
	@TableField(value = "service_cycle")
	private Integer serviceCycle;

	/** 服务月数 */
	@TableField(value = "month_number")
	private Integer monthNumber;

	/**  */
	private Integer teacher;

	/** 合同确认 0全部 1未确认 2已确认 */
	private Integer contact;

	/** 押金 */
	private BigDecimal deposit;

	/** 1未收取2已收取3已退还 */
	@TableField(value = "deposit_status")
	private Integer depositStatus;


	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getOrderStartDate() {
		return this.orderStartDate;
	}

	public void setOrderStartDate(Date orderStartDate) {
		this.orderStartDate = orderStartDate;
	}

	public Date getOrderEndDate() {
		return this.orderEndDate;
	}

	public void setOrderEndDate(Date orderEndDate) {
		this.orderEndDate = orderEndDate;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getBackup() {
		return this.backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
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

	public Integer getHouseId() {
		return this.houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getNeedJson() {
		return this.needJson;
	}

	public void setNeedJson(String needJson) {
		this.needJson = needJson;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
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

	public Integer getServiceCycle() {
		return this.serviceCycle;
	}

	public void setServiceCycle(Integer serviceCycle) {
		this.serviceCycle = serviceCycle;
	}

	public Integer getMonthNumber() {
		return this.monthNumber;
	}

	public void setMonthNumber(Integer monthNumber) {
		this.monthNumber = monthNumber;
	}

	public Integer getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Integer teacher) {
		this.teacher = teacher;
	}

	public Integer getContact() {
		return this.contact;
	}

	public void setContact(Integer contact) {
		this.contact = contact;
	}

	public BigDecimal getDeposit() {
		return this.deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public Integer getDepositStatus() {
		return this.depositStatus;
	}

	public void setDepositStatus(Integer depositStatus) {
		this.depositStatus = depositStatus;
	}

}
