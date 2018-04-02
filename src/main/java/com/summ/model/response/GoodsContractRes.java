package com.summ.model.response;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * 
 *
 */
public class GoodsContractRes {

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer goodsId;

	/**  */
	private String service;

	/**  */
	private BigDecimal price;

	/** 结算方式 */
	private String Settlement;

	private Integer orderType;
	private String orderTypeInfo;

	/**单位名称 */
	private String unitName;

	/**  */
	private Integer isDel;
	private Integer lowest;
	private String summary;

	public Integer getLowest() {
		return lowest;
	}

	public void setLowest(Integer lowest) {
		this.lowest = lowest;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getOrderTypeInfo() {
		return orderTypeInfo;
	}

	public void setOrderTypeInfo(String orderTypeInfo) {
		this.orderTypeInfo = orderTypeInfo;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSettlement() {
		return this.Settlement;
	}

	public void setSettlement(String Settlement) {
		this.Settlement = Settlement;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
