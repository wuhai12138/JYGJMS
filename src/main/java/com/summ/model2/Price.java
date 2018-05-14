package com.summ.model2;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *
 * 
 *
 */
public class Price implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "price_id", type = IdType.AUTO)
	private Integer priceId;

	/** 0没有1合同2包月3一次性 */
	@TableField(value = "order_type")
	private Integer orderType;

	/** 种类1 */
	@TableField(value = "service_category_one")
	private Integer serviceCategoryOne;

	/** 种类2 */
	@TableField(value = "service_category_two")
	private Integer serviceCategoryTwo;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 种类1名称 */
	@TableField(value = "category_one_name")
	private String categoryOneName;

	/** 种类2名称 */
	@TableField(value = "category_two_name")
	private String categoryTwoName;

	/** 成本价格 */
	private Integer cost;

	/** 售价 */
	@TableField(value = "price_money")
	private Integer priceMoney;

	/** 价格说明 */
	@TableField(value = "price_state")
	private String priceState;

	/**  */
	private Date modifytime;

	/**  */
	private Integer modifyid;

	/** 服务小时 */
	@TableField(value = "nanny_hour")
	private Double nannyHour;

	/** 1自营2外包0全部3其他 */
	@TableField(value = "service_type")
	private Integer serviceType;

	/** 最低价格 */
	@TableField(value = "min_price")
	private Double minPrice;

	/** 最高价格 */
	@TableField(value = "max_price")
	private Double maxPrice;


	public Integer getPriceId() {
		return this.priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
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

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getCategoryOneName() {
		return this.categoryOneName;
	}

	public void setCategoryOneName(String categoryOneName) {
		this.categoryOneName = categoryOneName;
	}

	public String getCategoryTwoName() {
		return this.categoryTwoName;
	}

	public void setCategoryTwoName(String categoryTwoName) {
		this.categoryTwoName = categoryTwoName;
	}

	public Integer getCost() {
		return this.cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getPriceMoney() {
		return this.priceMoney;
	}

	public void setPriceMoney(Integer priceMoney) {
		this.priceMoney = priceMoney;
	}

	public String getPriceState() {
		return this.priceState;
	}

	public void setPriceState(String priceState) {
		this.priceState = priceState;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getModifyid() {
		return this.modifyid;
	}

	public void setModifyid(Integer modifyid) {
		this.modifyid = modifyid;
	}

	public Double getNannyHour() {
		return this.nannyHour;
	}

	public void setNannyHour(Double nannyHour) {
		this.nannyHour = nannyHour;
	}

	public Integer getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Double getMinPrice() {
		return this.minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return this.maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

}
