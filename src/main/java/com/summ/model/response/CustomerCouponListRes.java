package com.summ.model.response;

import java.util.Date;

/**
 * Created by jygj_7500 on 17/11/28.
 */
public class CustomerCouponListRes {

    private Integer couponListId;

    /**  */
    private String couponCode = "";

    /**  */
    private Integer couponId;

    /**  */
    private Integer shopId;
    private String shopIdInfo;

    /**  */
    private Integer customerId;

    private Integer couponStatus = 32;
    private String couponStatusInfo;


    /**  */
    private Integer missionId;

    /**  */
    private Date createTime = new Date();

    /**  */
    private Integer isDel = 16;
    private String isDelInfo;

    /**  */
    private String couponName;

    /**  */
    private String couponDetail;

    /**  */
    private Double couponPrice;

    /**  */
    private Date validTime;

    /**  */
    private String couponOrigin;
    private String couponOriginInfo;


    public Integer getCouponListId() {
        return couponListId;
    }

    public void setCouponListId(Integer couponListId) {
        this.couponListId = couponListId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopIdInfo() {
        return shopIdInfo;
    }

    public void setShopIdInfo(String shopIdInfo) {
        this.shopIdInfo = shopIdInfo;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    public String getCouponStatusInfo() {
        return couponStatusInfo;
    }

    public void setCouponStatusInfo(String couponStatusInfo) {
        this.couponStatusInfo = couponStatusInfo;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer missionId) {
        this.missionId = missionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getIsDelInfo() {
        return isDelInfo;
    }

    public void setIsDelInfo(String isDelInfo) {
        this.isDelInfo = isDelInfo;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponDetail() {
        return couponDetail;
    }

    public void setCouponDetail(String couponDetail) {
        this.couponDetail = couponDetail;
    }

    public Double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public String getCouponOrigin() {
        return couponOrigin;
    }

    public void setCouponOrigin(String couponOrigin) {
        this.couponOrigin = couponOrigin;
    }

    public String getCouponOriginInfo() {
        return couponOriginInfo;
    }

    public void setCouponOriginInfo(String couponOriginInfo) {
        this.couponOriginInfo = couponOriginInfo;
    }
}