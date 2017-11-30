package com.summ.model.request;

/**
 * Created by jygj_7500 on 17/11/29.
 */
public class CustomerStatmentReq {

    private int customerId;
    private int statmentType;
    private int page;
    private int size;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStatmentType() {
        return statmentType;
    }

    public void setStatmentType(int statmentType) {
        this.statmentType = statmentType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
