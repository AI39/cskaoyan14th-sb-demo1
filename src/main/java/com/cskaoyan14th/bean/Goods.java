package com.cskaoyan14th.bean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class Goods {
    private Integer id;

    private String goodsSn;

    private String name;

    private Integer categoryId;

    private Integer brandId;

    private String[] gallery;

    private String keywords;

    private String brief;

    private Boolean isOnSale;

    private Short sortOrder;

    private String picUrl;

    private String shareUrl;

    private Boolean isNew;

    private Boolean isHot;

    private String unit;

    private BigDecimal counterPrice;

    private BigDecimal retailPrice;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String[] getGallery() {
        return gallery;
    }

    public void setGallery(String[] gallery) {
        this.gallery = gallery;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Boolean getOnSale() {
        return isOnSale;
    }

    public void setOnSale(Boolean onSale) {
        isOnSale = onSale;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsSn='" + goodsSn + '\'' +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", gallery=" + Arrays.toString(gallery) +
                ", keywords='" + keywords + '\'' +
                ", brief='" + brief + '\'' +
                ", isOnSale=" + isOnSale +
                ", sortOrder=" + sortOrder +
                ", picUrl='" + picUrl + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", isNew=" + isNew +
                ", isHot=" + isHot +
                ", unit='" + unit + '\'' +
                ", counterPrice=" + counterPrice +
                ", retailPrice=" + retailPrice +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Goods() {
    }

    public Goods(Integer id, String goodsSn, String name, Integer categoryId, Integer brandId, String[] gallery, String keywords, String brief, Boolean isOnSale, Short sortOrder, String picUrl, String shareUrl, Boolean isNew, Boolean isHot, String unit, BigDecimal counterPrice, BigDecimal retailPrice, Date addTime, Date updateTime, Boolean deleted, String detail) {
        this.id = id;
        this.goodsSn = goodsSn;
        this.name = name;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.gallery = gallery;
        this.keywords = keywords;
        this.brief = brief;
        this.isOnSale = isOnSale;
        this.sortOrder = sortOrder;
        this.picUrl = picUrl;
        this.shareUrl = shareUrl;
        this.isNew = isNew;
        this.isHot = isHot;
        this.unit = unit;
        this.counterPrice = counterPrice;
        this.retailPrice = retailPrice;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
        this.detail = detail;
    }
}