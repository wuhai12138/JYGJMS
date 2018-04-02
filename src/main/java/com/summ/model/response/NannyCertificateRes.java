package com.summ.model.response;

/**
 * Created by jygj_7500 on 17/12/14.
 */
public class NannyCertificateRes {

    /**
     * certificateId : 2
     * certificateIdInfo :
     */

    private int nannyCertId;
    private String certificateIdInfo;
    private String photo;
    private Integer certificateId;

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNannyCertId() {
        return nannyCertId;
    }

    public void setNannyCertId(int nannyCertId) {
        this.nannyCertId = nannyCertId;
    }

    public String getCertificateIdInfo() {
        return certificateIdInfo;
    }

    public void setCertificateIdInfo(String certificateIdInfo) {
        this.certificateIdInfo = certificateIdInfo;
    }
}
