package com.summ.model.request;

import java.util.Date;

/**
 * Created by jygj_7500 on 18/1/24.
 */
public class NannyWortTimeByOrderReq {
    private Integer nannyId;
    private Date startDate;
    private Date endDate;

    public Integer getNannyId() {
        return nannyId;
    }

    public void setNannyId(Integer nannyId) {
        this.nannyId = nannyId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
