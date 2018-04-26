package com.wsx.park.system.domain.parking_system;

import java.util.Date;

public class RechargeHistory {
    private Integer id;

    private Integer userId;

    private Double countFee;

    private Double rechargeFee;

    private Integer payType;

    private Byte isDel;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getCountFee() {
        return countFee;
    }

    public void setCountFee(Double countFee) {
        this.countFee = countFee;
    }

    public Double getRechargeFee() {
        return rechargeFee;
    }

    public void setRechargeFee(Double rechargeFee) {
        this.rechargeFee = rechargeFee;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}