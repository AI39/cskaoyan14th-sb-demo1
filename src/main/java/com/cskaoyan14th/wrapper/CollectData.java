package com.cskaoyan14th.wrapper;

import java.math.BigDecimal;

public class CollectData {
    private Integer id;

    private Integer valueId;

    private Byte type;

    private String name;

    private String brief;

    private String picUrl;

    private BigDecimal retailPrice;

    public CollectData() {
    }

    public CollectData(Integer id, Integer valueId, Byte type, String name, String brief, String picUrl, BigDecimal retailPrice) {
        this.id = id;
        this.valueId = valueId;
        this.type = type;
        this.name = name;
        this.brief = brief;
        this.picUrl = picUrl;
        this.retailPrice = retailPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "CollectData{" +
                "id=" + id +
                ", valueId=" + valueId +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", retailPrice=" + retailPrice +
                '}';
    }
}
