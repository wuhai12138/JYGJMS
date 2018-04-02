package com.summ.model.request;

/**
 * Created by jygj_7500 on 18/1/26.
 */
public class CustomerReq {
    /**客户基本信息*/
    private String customerName;
    private String customerPhone;
    private Integer customerSex;
    private String remark;

    /**客户房产基本信息*/
    private Integer areaId;
    private String houseAddress;
    private Integer bedRoom;
    private Integer livingRoom;
    private Integer restRoom;
    private String houseArea;

    /**房产服务计划书信息*/
    private String serviceDetail;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(Integer customerSex) {
        this.customerSex = customerSex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public Integer getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(Integer bedRoom) {
        this.bedRoom = bedRoom;
    }

    public Integer getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(Integer livingRoom) {
        this.livingRoom = livingRoom;
    }

    public Integer getRestRoom() {
        return restRoom;
    }

    public void setRestRoom(Integer restRoom) {
        this.restRoom = restRoom;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }
}