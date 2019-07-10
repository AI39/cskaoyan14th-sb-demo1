package com.cskaoyan14th.bean;

import java.util.Arrays;

import java.util.Date;

public class Feedback {

    private Integer id;

    private Integer userId;

    private String username;

    private String mobile;

    private String feedType;

    private String content;

    private Integer status;

    private Boolean hasPicture;

    private String[] picUrls;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(Boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
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

    public Feedback(Integer id, Integer userId, String username, String mobile, String feedType, String content, Integer status, Boolean hasPicture, String[] picUrls, Date addTime, Date updateTime, Boolean deleted) {
        this.id = id;

        this.userId = userId;

        this.username = username;

        this.mobile = mobile;
        this.feedType = feedType;
        this.content = content;
        this.status = status;
        this.hasPicture = hasPicture;
        this.picUrls = picUrls;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public Feedback() {
    }

    @Override
    public String toString() {

        return "Feedback{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", mobile='" + mobile + '\'' +
                ", feedType='" + feedType + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", hasPicture=" + hasPicture +
                ", picUrls=" + Arrays.toString(picUrls) +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}