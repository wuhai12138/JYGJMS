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
@TableName("j_order_temp")
public class JOrderTemp implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer orderId;

	/**  */
	private Integer customerId;

	/**  */
	private Integer shopId;

	/**  */
	private Integer houseId;

	/** 订单状态 */
	private Integer orderStatus=142;

	/** 订单关闭状态（默认未关闭） */
	private Integer orderCloseStatus;

	/**  */
	private Integer goodsId;


	/** 订单日期 */
	private Date orderDate;

	/** 开始时间Id */
	private Integer startTime;

	/** 结束时间Id */
	private Integer endTime;

	private String startTimeValue;

	private String endTimeValue;

	/**  */
	private Integer teacherId;

	/** 单价 */
	private BigDecimal unitPrice;

	/** 服务数量（平方米，个等等） */
	private Integer serviceAmount;

	/** 总价 */
	private BigDecimal totalPrice;

	/** 优惠金额 */
	private BigDecimal discount=new BigDecimal(0);

	private Integer couponListId;

	/** 实付金额 */
	private BigDecimal payMoney;

	/** 支付状态 */
	private Integer payStatus=157;

	/**  */
	private Date createTime=new Date();

	/**  */
	private Integer createId;

	/**  */
	private Integer modifyId;

	/**  */
	private Date modifyTime;
	/**  */
	private String remark;

	/**  */
	private Integer isDel=16;

	public Integer getOrderCloseStatus() {
		return orderCloseStatus;
	}

	public void setOrderCloseStatus(Integer orderCloseStatus) {
		this.orderCloseStatus = orderCloseStatus;
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Integer getModifyId() {
		return modifyId;
	}

	public void setModifyId(Integer modifyId) {
		this.modifyId = modifyId;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getCouponListId() {
		return couponListId;
	}

	public void setCouponListId(Integer couponListId) {
		this.couponListId = couponListId;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public String getStartTimeValue() {
		return startTimeValue;
	}

	public void setStartTimeValue(String startTimeValue) {
		this.startTimeValue = startTimeValue;
	}

	public String getEndTimeValue() {
		return endTimeValue;
	}

	public void setEndTimeValue(String endTimeValue) {
		this.endTimeValue = endTimeValue;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getHouseId() {
		return this.houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}


	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getServiceAmount() {
		return this.serviceAmount;
	}

	public void setServiceAmount(Integer serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getPayMoney() {
		return this.payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
