package com.summ.model;

import java.io.Serializable;
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
@TableName("j_goods_contract")
public class JGoodsContract implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer goodsId;

	/**  */
	private String service;

	/**  */
	private BigDecimal price;

	/** 结算方式 */
	private String Settlement="1";

	private Integer orderType=164;

	/**单位名称 */
	private String unitName;

	/** 表示产品上下架状态，16表示上架17表示下架 */
	private Integer isDel=17;

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
