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
@TableName("order_small")
public class OrderSmall implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 小订单id */
	@TableId(value = "mission_id", type = IdType.AUTO)
	private Integer missionId;

	/** 日期 */
	@TableField(value = "mission_date")
	private Date missionDate;

	/** 小订单销售总价 */
	@TableField(value = "mission_price")
	private String missionPrice;

	/** 小订单成本总价 */
	@TableField(value = "mission_cost")
	private Double missionCost;

	/** 星期 */
	@TableField(value = "mission_week")
	private Integer missionWeek;

	/** 门店id */
	@TableField(value = "shop_id")
	private Integer shopId;

	/** 房产id */
	@TableField(value = "house_id")
	private Integer houseId;

	/** 时间 */
	@TableField(value = "mission_time")
	private String missionTime;

	/** 工时 */
	@TableField(value = "mission_hour")
	private Double missionHour;

	/** 0全部1未开工2已完工3已暂停4已取消 */
	@TableField(value = "mission_status")
	private Integer missionStatus;

	/** 备注 */
	@TableField(value = "mission_backup")
	private String missionBackup;

	/** 培训中心id */
	@TableField(value = "train_id")
	private Integer trainId;

	/** 创建时间 */
	private String createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 所属大订单id */
	@TableField(value = "order_id")
	private Integer orderId;

	/** 服务类型1 */
	@TableField(value = "service_category_one")
	private Integer serviceCategoryOne;

	/** 服务类型2 */
	@TableField(value = "service_category_two")
	private Integer serviceCategoryTwo;

	/** 0全部1合同2包月3一次性4免费5包年 */
	@TableField(value = "order_type")
	private Integer orderType;

	/** 时间值 */
	@TableField(value = "time_value")
	private Integer timeValue;

	/** 数量 */
	private BigDecimal number;

	/** 服务种类id */
	@TableField(value = "price_id")
	private Integer priceId;

	/** 1正常订单2试工订单3包年付款 */
	@TableField(value = "mission_type")
	private Integer missionType;

	/** 小订单评价评语 */
	@TableField(value = "mission_comment")
	private String missionComment;

	/** 评价分数 6未评价 */
	@TableField(value = "mission_grade")
	private Integer missionGrade;

	/** 取消订单备注 */
	@TableField(value = "cancel_backup")
	private String cancelBackup;


	public Integer getMissionId() {
		return this.missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public Date getMissionDate() {
		return this.missionDate;
	}

	public void setMissionDate(Date missionDate) {
		this.missionDate = missionDate;
	}

	public String getMissionPrice() {
		return this.missionPrice;
	}

	public void setMissionPrice(String missionPrice) {
		this.missionPrice = missionPrice;
	}

	public Double getMissionCost() {
		return this.missionCost;
	}

	public void setMissionCost(Double missionCost) {
		this.missionCost = missionCost;
	}

	public Integer getMissionWeek() {
		return this.missionWeek;
	}

	public void setMissionWeek(Integer missionWeek) {
		this.missionWeek = missionWeek;
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

	public String getMissionTime() {
		return this.missionTime;
	}

	public void setMissionTime(String missionTime) {
		this.missionTime = missionTime;
	}

	public Double getMissionHour() {
		return this.missionHour;
	}

	public void setMissionHour(Double missionHour) {
		this.missionHour = missionHour;
	}

	public Integer getMissionStatus() {
		return this.missionStatus;
	}

	public void setMissionStatus(Integer missionStatus) {
		this.missionStatus = missionStatus;
	}

	public String getMissionBackup() {
		return this.missionBackup;
	}

	public void setMissionBackup(String missionBackup) {
		this.missionBackup = missionBackup;
	}

	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
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

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getServiceCategoryOne() {
		return this.serviceCategoryOne;
	}

	public void setServiceCategoryOne(Integer serviceCategoryOne) {
		this.serviceCategoryOne = serviceCategoryOne;
	}

	public Integer getServiceCategoryTwo() {
		return this.serviceCategoryTwo;
	}

	public void setServiceCategoryTwo(Integer serviceCategoryTwo) {
		this.serviceCategoryTwo = serviceCategoryTwo;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getTimeValue() {
		return this.timeValue;
	}

	public void setTimeValue(Integer timeValue) {
		this.timeValue = timeValue;
	}

	public BigDecimal getNumber() {
		return this.number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public Integer getPriceId() {
		return this.priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public Integer getMissionType() {
		return this.missionType;
	}

	public void setMissionType(Integer missionType) {
		this.missionType = missionType;
	}

	public String getMissionComment() {
		return this.missionComment;
	}

	public void setMissionComment(String missionComment) {
		this.missionComment = missionComment;
	}

	public Integer getMissionGrade() {
		return this.missionGrade;
	}

	public void setMissionGrade(Integer missionGrade) {
		this.missionGrade = missionGrade;
	}

	public String getCancelBackup() {
		return this.cancelBackup;
	}

	public void setCancelBackup(String cancelBackup) {
		this.cancelBackup = cancelBackup;
	}

}
