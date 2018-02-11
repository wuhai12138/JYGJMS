package com.summ.model.request;

/**
 * Created by jygj_7500 on 18/1/28.
 */
public class CustomerFeedbackReq {
    private Integer page;
    private Integer size;
    private Integer department=0;

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
