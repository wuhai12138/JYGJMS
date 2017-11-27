package com.summ.model.request;

/**
 * Created by jygj_7500 on 17/11/20.
 */
public class PaginateReq {
    private Integer page;
    private Integer size;

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
