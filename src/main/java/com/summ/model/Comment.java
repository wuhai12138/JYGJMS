package com.summ.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *
 * 评分表
 *
 */
public class Comment implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键 */
	@TableId(value = "comment_id", type = IdType.AUTO)
	private Integer commentId;

	/** 小订单id */
	@TableField(value = "mission_id")
	private Integer missionId;

	/** 评分(默认0,满分5分 取值范围 1-5 ) */
	@TableField(value = "mission_score")
	private Integer missionScore;

	/** 评语 */
	@TableField(value = "mission_content")
	private String missionContent;


	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getMissionId() {
		return this.missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public Integer getMissionScore() {
		return this.missionScore;
	}

	public void setMissionScore(Integer missionScore) {
		this.missionScore = missionScore;
	}

	public String getMissionContent() {
		return this.missionContent;
	}

	public void setMissionContent(String missionContent) {
		this.missionContent = missionContent;
	}

}
