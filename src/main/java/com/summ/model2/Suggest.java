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
public class Suggest implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "suggest_id", type = IdType.AUTO)
	private Integer suggestId;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 客户id */
	@TableField(value = "customer_id")
	private Integer customerId;

	/** 0全部1留言2电话3微信4系统提醒 */
	@TableField(value = "suggest_type")
	private Integer suggestType;

	/**  */
	@TableField(value = "suggest_content")
	private String suggestContent;

	/** 门店id */
	@TableField(value = "shop_id")
	private Integer shopId;

	/** 0全部1未处理2已处理 */
	@TableField(value = "suggest_status")
	private Integer suggestStatus;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;


	public Integer getSuggestId() {
		return this.suggestId;
	}

	public void setSuggestId(Integer suggestId) {
		this.suggestId = suggestId;
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

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getSuggestType() {
		return this.suggestType;
	}

	public void setSuggestType(Integer suggestType) {
		this.suggestType = suggestType;
	}

	public String getSuggestContent() {
		return this.suggestContent;
	}

	public void setSuggestContent(String suggestContent) {
		this.suggestContent = suggestContent;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getSuggestStatus() {
		return this.suggestStatus;
	}

	public void setSuggestStatus(Integer suggestStatus) {
		this.suggestStatus = suggestStatus;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

}
