package com.summ.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 大订单推送表
 *
 */
@TableName("order_big_push")
public class OrderBigPush implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "push_id", type = IdType.AUTO)
	private Integer pushId;

	/** 大订单id */
	@TableField(value = "order_id")
	private Integer orderId;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 是否接受 0 未处理 1 已接受 2已拒绝 */
	@TableField(value = "is_accept")
	private Integer isAccept;

	/**  */
	private Integer createid;

	/**  */
	private Integer modifyid;

	/**  */
	private Integer isDel;

	/**  */
	private Date createtime;

	/**  */
	private Date modifytime;


	public Integer getPushId() {
		return this.pushId;
	}

	public void setPushId(Integer pushId) {
		this.pushId = pushId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public Integer getIsAccept() {
		return this.isAccept;
	}

	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
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

}
