package com.wsx.park.system.domain.parking_system;

import java.util.Date;

public class Park {
    private Integer id;

    private Integer userId;

    private String carId;

    private Integer parkingSpaceId;

    private Date startParkTime;

    private Date endParkTime;

    private Double fee;

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

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public Integer getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(Integer parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public Date getStartParkTime() {
        return startParkTime;
    }

    public void setStartParkTime(Date startParkTime) {
        this.startParkTime = startParkTime;
    }

    public Date getEndParkTime() {
        return endParkTime;
    }

    public void setEndParkTime(Date endParkTime) {
        this.endParkTime = endParkTime;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
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