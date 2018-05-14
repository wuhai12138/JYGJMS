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
@TableName("shareholder_shop")
public class ShareholderShop implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**  */
	private Integer shareholderid;

	/**  */
	private Integer shopid;

	/** 是否删除(1为已删除) */
	private Integer isdel;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/**  */
	private BigDecimal proportion;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShareholderid() {
		return this.shareholderid;
	}

	public void setShareholderid(Integer shareholderid) {
		this.shareholderid = shareholderid;
	}

	public Integer getShopid() {
		return this.shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public Integer getIsdel() {
		return this.isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
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

	public BigDecimal getProportion() {
		return this.proportion;
	}

	public void setProportion(BigDecimal proportion) {
		this.proportion = proportion;
	}

}
