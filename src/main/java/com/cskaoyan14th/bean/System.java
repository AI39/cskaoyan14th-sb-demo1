package com.cskaoyan14th.bean;

import java.util.Date;

public class System {
    private Integer id;

    private SystemKeyValue systemKeyValue;

    private SystemFrightMin systemFrightMin;

    private SystemOrderComment systemOrderComment;

    private SystemWx systemWx;

    private String keyValue;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SystemKeyValue getSystemKeyValue() {
        return systemKeyValue;
    }

    public void setSystemKeyValue(SystemKeyValue systemKeyValue) {
        this.systemKeyValue = systemKeyValue;
    }

    public SystemFrightMin getSystemFrightMin() {
        return systemFrightMin;
    }

    public void setSystemFrightMin(SystemFrightMin systemFrightMin) {
        this.systemFrightMin = systemFrightMin;
    }

    public SystemOrderComment getSystemOrderComment() {
        return systemOrderComment;
    }

    public void setSystemOrderComment(SystemOrderComment systemOrderComment) {
        this.systemOrderComment = systemOrderComment;
    }

    public SystemWx getSystemWx() {
        return systemWx;
    }

    public void setSystemWx(SystemWx systemWx) {
        this.systemWx = systemWx;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public System(Integer id, SystemKeyValue systemKeyValue, SystemFrightMin systemFrightMin, SystemOrderComment systemOrderComment, SystemWx systemWx, String keyValue, Date addTime, Date updateTime, Boolean deleted) {
        this.id = id;
        this.systemKeyValue = systemKeyValue;
        this.systemFrightMin = systemFrightMin;
        this.systemOrderComment = systemOrderComment;
        this.systemWx = systemWx;
        this.keyValue = keyValue;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public System() {
    }

    @Override
    public String toString() {
        return "System{" +
                "id=" + id +
                ", systemKeyValue=" + systemKeyValue +
                ", systemFrightMin=" + systemFrightMin +
                ", systemOrderComment=" + systemOrderComment +
                ", systemWx=" + systemWx +
                ", keyValue='" + keyValue + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}