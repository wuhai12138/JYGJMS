package com.summ.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 服务师评分表
 *
 */
@TableName("nanny_score")
public class NannyScore implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** id */
	@TableId(value = "score_id", type = IdType.AUTO)
	private Integer scoreId;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 分数 */
	@TableField(value = "nanny_score")
	private Integer nannyScore;

	/** 小订单id */
	@TableField(value = "order_small_id")
	private Integer orderSmallId;

	/** 创建人id */
	private Integer createid;

	/**  */
	private Date createtime;

	/**  */
	private Integer modifyid;

	/**  */
	private Date mofifytime;

	/** 评语 */
	@TableField(value = "nanny_comment")
	private String nannyComment;

	/**  */
	private Integer isDel;


	public Integer getScoreId() {
		return this.scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public Integer getNannyScore() {
		return this.nannyScore;
	}

	public void setNannyScore(Integer nannyScore) {
		this.nannyScore = nannyScore;
	}

	public Integer getOrderSmallId() {
		return this.orderSmallId;
	}

	public void setOrderSmallId(Integer orderSmallId) {
		this.orderSmallId = orderSmallId;
	}

	public Integer getCreateid() {
		return this.createid;
	}

	public void setCreateid(Integer createid) {
		this.createid = createid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getModifyid() {
		return this.modifyid;
	}

	public void setModifyid(Integer modifyid) {
		this.modifyid = modifyid;
	}

	public Date getMofifytime() {
		return this.mofifytime;
	}

	public void setMofifytime(Date mofifytime) {
		this.mofifytime = mofifytime;
	}

	public String getNannyComment() {
		return this.nannyComment;
	}

	public void setNannyComment(String nannyComment) {
		this.nannyComment = nannyComment;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
