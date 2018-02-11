package com.summ.model.response;

import java.util.Date;

/**
 * Created by jygj_7500 on 18/1/26.
 */
public class ShopRes {
    private Integer shopId;

    /**  */
    private Integer trainId;

    /**  */
    private String shopName;

    /**  */
    private String shopPhone;

    /**  */
    private String shopAddress;

    /**  */
    private String shopPayCode;

    /**  */
    private String shopUrl;

    /**  */
    private double longitude;

    /**  */
    private double latitude;

    private Integer staring;

    /**  */
    private Integer isDel = 16;

    /**  */
    private Date createTime;

    /**  */
    private Date modifyTime;

    private double distance;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopPayCode() {
        return shopPayCode;
    }

    public void setShopPayCode(String shopPayCode) {
        this.shopPayCode = shopPayCode;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Integer getStaring() {
        return staring;
    }

    public void setStaring(Integer staring) {
        this.staring = staring;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
