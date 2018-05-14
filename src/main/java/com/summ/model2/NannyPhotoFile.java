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
@TableName("nanny_photo_file")
public class NannyPhotoFile implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "file_id", type = IdType.AUTO)
	private Integer fileId;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 文件名称 */
	@TableField(value = "file_name")
	private String fileName;

	/** 文件备注 */
	@TableField(value = "file_back")
	private String fileBack;

	/** 文件类型 例: 1 身份证照 2 证书照 */
	@TableField(value = "file_type")
	private Integer fileType;

	/** 创建时间 */
	private Date createtime;

	/** 创建人id */
	private Integer createid;

	/** 修改时间 */
	private Date modifytime;

	/** 修改人id */
	private Integer modifyid;

	/** 0未删除1已删除 */
	private Integer isDel;


	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileBack() {
		return this.fileBack;
	}

	public void setFileBack(String fileBack) {
		this.fileBack = fileBack;
	}

	public Integer getFileType() {
		return this.fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getCreateid() {
		return this.createid;
	}

	public void setCreateid(Integer createid) {
		this.createid = createid;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
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

}
