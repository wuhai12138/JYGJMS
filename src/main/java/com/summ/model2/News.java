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
public class News implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "news_id", type = IdType.AUTO)
	private Integer newsId;

	/**  */
	@TableField(value = "news_title")
	private String newsTitle;

	/**  */
	@TableField(value = "news_content")
	private String newsContent;

	/**  */
	@TableField(value = "news_img")
	private String newsImg;

	/**  */
	private Date createtime;

	/**  */
	private Date modifytime;

	/**  */
	private Integer createid;

	/**  */
	private Integer modifyid;

	/**  */
	private Integer isDel;

	/**  */
	private Integer type;

	/**  */
	@TableField(value = "news_href")
	private String newsHref;


	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsImg() {
		return this.newsImg;
	}

	public void setNewsImg(String newsImg) {
		this.newsImg = newsImg;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getNewsHref() {
		return this.newsHref;
	}

	public void setNewsHref(String newsHref) {
		this.newsHref = newsHref;
	}

}
