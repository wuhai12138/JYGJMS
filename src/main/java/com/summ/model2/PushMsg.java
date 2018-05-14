package com.summ.model2;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("push_msg")
public class PushMsg implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "msg_id", type = IdType.AUTO)
	private Integer msgId;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 客户id */
	@TableField(value = "customer_id")
	private Integer customerId;

	/** 消息内容 */
	@TableField(value = "msg_content")
	private String msgContent;

	/** 0全部1未读2已读 */
	@TableField(value = "msg_status")
	private Integer msgStatus;

	/** 门店id */
	@TableField(value = "shop_id")
	private Integer shopId;

	/** 0全部1注册消息(跳转html)2推广消息(跳转html)3大订单消息(跳转订单列表)4通知消息（服务端用）5小订单消息(跳转小订单详情)6(明日订单消息) */
	@TableField(value = "msg_type")
	private Integer msgType;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 网页 */
	@TableField(value = "msg_html")
	private String msgHtml;


	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
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

	public String getMsgContent() {
		return this.msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Integer getMsgStatus() {
		return this.msgStatus;
	}

	public void setMsgStatus(Integer msgStatus) {
		this.msgStatus = msgStatus;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getMsgType() {
		return this.msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public String getMsgHtml() {
		return this.msgHtml;
	}

	public void setMsgHtml(String msgHtml) {
		this.msgHtml = msgHtml;
	}

}
