package com.cskaoyan14th.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yuechao Yang
 * @version 2019-07-10-15:03
 */
public class WxFootprint {
    private Integer id;

    private Integer userId;

    private Integer goodsId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Boolean deleted;

    private String name;

    private String brief;

    private String picUrl;

    private BigDecimal retailPrice;

    public WxFootprint() {
    }

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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public WxFootprint(Integer userId, Integer goodsId, Date addTime, Date updateTime, Boolean deleted, String name, String brief, String picUrl, BigDecimal retailPrice) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
        this.name = name;
        this.brief = brief;
        this.picUrl = picUrl;
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "WxFootprint{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                ", name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", retailPrice=" + retailPrice +
                '}';
    }
}
