package com.summ.model;

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
@TableName("nanny_work_time")
public class NannyWorkTime implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/** 周一 */
	@TableField(value = "mon_day")
	private Integer monDay;

	/**  */
	@TableField(value = "mon_night")
	private Integer monNight;

	/** 二 */
	@TableField(value = "tue_day")
	private Integer tueDay;

	/**  */
	@TableField(value = "tue_night")
	private Integer tueNight;

	/** 三 */
	@TableField(value = "wed_day")
	private Integer wedDay;

	/**  */
	@TableField(value = "wed_night")
	private Integer wedNight;

	/** 四 */
	@TableField(value = "thu_day")
	private Integer thuDay;

	/**  */
	@TableField(value = "thu_night")
	private Integer thuNight;

	/** 五 */
	@TableField(value = "fri_day")
	private Integer friDay;

	/**  */
	@TableField(value = "fri_night")
	private Integer friNight;

	/** 六 */
	@TableField(value = "sat_day")
	private Integer satDay;

	/**  */
	@TableField(value = "sat_night")
	private Integer satNight;

	/** 日 */
	@TableField(value = "sun_day")
	private Integer sunDay;

	/**  */
	@TableField(value = "sun_night")
	private Integer sunNight;

	/** 服务师id */
	@TableField(value = "nanny_id")
	private Integer nannyId;

	/** 1为已删除 */
	private Integer isDel;

	/** 创建时间 */
	private Date createtime;

	/** 更新时间 */
	private Date modifytime;

	/** 创建人id */
	private Integer createid;

	/** 修改人id */
	private Integer modifyid;

	/** 备注 */
	@TableField(value = "time_backup")
	private String timeBackup;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMonDay() {
		return this.monDay;
	}

	public void setMonDay(Integer monDay) {
		this.monDay = monDay;
	}

	public Integer getMonNight() {
		return this.monNight;
	}

	public void setMonNight(Integer monNight) {
		this.monNight = monNight;
	}

	public Integer getTueDay() {
		return this.tueDay;
	}

	public void setTueDay(Integer tueDay) {
		this.tueDay = tueDay;
	}

	public Integer getTueNight() {
		return this.tueNight;
	}

	public void setTueNight(Integer tueNight) {
		this.tueNight = tueNight;
	}

	public Integer getWedDay() {
		return this.wedDay;
	}

	public void setWedDay(Integer wedDay) {
		this.wedDay = wedDay;
	}

	public Integer getWedNight() {
		return this.wedNight;
	}

	public void setWedNight(Integer wedNight) {
		this.wedNight = wedNight;
	}

	public Integer getThuDay() {
		return this.thuDay;
	}

	public void setThuDay(Integer thuDay) {
		this.thuDay = thuDay;
	}

	public Integer getThuNight() {
		return this.thuNight;
	}

	public void setThuNight(Integer thuNight) {
		this.thuNight = thuNight;
	}

	public Integer getFriDay() {
		return this.friDay;
	}

	public void setFriDay(Integer friDay) {
		this.friDay = friDay;
	}

	public Integer getFriNight() {
		return this.friNight;
	}

	public void setFriNight(Integer friNight) {
		this.friNight = friNight;
	}

	public Integer getSatDay() {
		return this.satDay;
	}

	public void setSatDay(Integer satDay) {
		this.satDay = satDay;
	}

	public Integer getSatNight() {
		return this.satNight;
	}

	public void setSatNight(Integer satNight) {
		this.satNight = satNight;
	}

	public Integer getSunDay() {
		return this.sunDay;
	}

	public void setSunDay(Integer sunDay) {
		this.sunDay = sunDay;
	}

	public Integer getSunNight() {
		return this.sunNight;
	}

	public void setSunNight(Integer sunNight) {
		this.sunNight = sunNight;
	}

	public Integer getNannyId() {
		return this.nannyId;
	}

	public void setNannyId(Integer nannyId) {
		this.nannyId = nannyId;
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

	public String getTimeBackup() {
		return this.timeBackup;
	}

	public void setTimeBackup(String timeBackup) {
		this.timeBackup = timeBackup;
	}

}
