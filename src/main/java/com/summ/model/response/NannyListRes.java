package com.summ.model.response;

import java.util.Date;

/**
 * Created by jygj_7500 on 17/12/13.
 */
public class NannyListRes {
    private Integer nannyId;
    String nannyName;
    private String nannyPhone;
    private Date createTime;
    private Integer nannyStatus;
    private String nannyStatusInfo;
    private Integer nannyAge;
    private String remark;

    public Integer getNannyId() {
        return nannyId;
    }

    public void setNannyId(Integer nannyId) {
        this.nannyId = nannyId;
    }

    public String getNannyName() {
        return nannyName;
    }

    public void setNannyName(String nannyName) {
        this.nannyName = nannyName;
    }

    public String getNannyPhone() {
        return nannyPhone;
    }

    public void setNannyPhone(String nannyPhone) {
        this.nannyPhone = nannyPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getNannyStatus() {
        return nannyStatus;
    }

    public void setNannyStatus(Integer nannyStatus) {
        this.nannyStatus = nannyStatus;
    }

    public String getNannyStatusInfo() {
        return nannyStatusInfo;
    }

    public void setNannyStatusInfo(String nannyStatusInfo) {
        this.nannyStatusInfo = nannyStatusInfo;
    }

    public Integer getNannyAge() {
        return nannyAge;
    }

    public void setNannyAge(Integer nannyAge) {
        this.nannyAge = nannyAge;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
