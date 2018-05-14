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
public class Shareholder implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "shareholder_id", type = IdType.AUTO)
	private Integer shareholderId;

	/** 股东姓名 */
	@TableField(value = "shareholder_name")
	private String shareholderName;

	/** 股东电话 */
	@TableField(value = "shareholder_phone")
	private String shareholderPhone;

	/** 备注 */
	@TableField(value = "shareholder_backup")
	private String shareholderBackup;

	/** 账号 */
	@TableField(value = "shareholder_account")
	private String shareholderAccount;

	/** 密码 */
	@TableField(value = "shareholder_password")
	private String shareholderPassword;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;

	/** 创建时间 */
	private Date createtime;

	/** 修改时间 */
	private Date modifytime;

	/** 0未删除1已删除 */
	private Integer isDel;


	public Integer getShareholderId() {
		return this.shareholderId;
	}

	public void setShareholderId(Integer shareholderId) {
		this.shareholderId = shareholderId;
	}

	public String getShareholderName() {
		return this.shareholderName;
	}

	public void setShareholderName(String shareholderName) {
		this.shareholderName = shareholderName;
	}

	public String getShareholderPhone() {
		return this.shareholderPhone;
	}

	public void setShareholderPhone(String shareholderPhone) {
		this.shareholderPhone = shareholderPhone;
	}

	public String getShareholderBackup() {
		return this.shareholderBackup;
	}

	public void setShareholderBackup(String shareholderBackup) {
		this.shareholderBackup = shareholderBackup;
	}

	public String getShareholderAccount() {
		return this.shareholderAccount;
	}

	public void setShareholderAccount(String shareholderAccount) {
		this.shareholderAccount = shareholderAccount;
	}

	public String getShareholderPassword() {
		return this.shareholderPassword;
	}

	public void setShareholderPassword(String shareholderPassword) {
		this.shareholderPassword = shareholderPassword;
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

}
