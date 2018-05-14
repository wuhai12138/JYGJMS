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
public class Version implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 版本号 */
	@TableField(value = "version_code")
	private Integer versionCode;

	/** 版本名称 例如1.0.0 */
	@TableField(value = "version_name")
	private String versionName;

	/** 下载地址 */
	@TableField(value = "download_url")
	private String downloadUrl;

	/** 更新内容 */
	private String backup;

	/**  */
	private Date createtime;

	/** 0未删除1已删除 */
	private Integer isDel;

	/** 版本类型 1客户,2服务师,3管家,4股东 */
	@TableField(value = "version_type")
	private Integer versionType;

	/** 版本平台 0全部,1安卓,2苹果,3windows */
	@TableField(value = "version_platform")
	private Integer versionPlatform;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer versionid;


	public Integer getVersionCode() {
		return this.versionCode;
	}

	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return this.versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getDownloadUrl() {
		return this.downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getBackup() {
		return this.backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getVersionType() {
		return this.versionType;
	}

	public void setVersionType(Integer versionType) {
		this.versionType = versionType;
	}

	public Integer getVersionPlatform() {
		return this.versionPlatform;
	}

	public void setVersionPlatform(Integer versionPlatform) {
		this.versionPlatform = versionPlatform;
	}

	public Integer getVersionid() {
		return this.versionid;
	}

	public void setVersionid(Integer versionid) {
		this.versionid = versionid;
	}

}
