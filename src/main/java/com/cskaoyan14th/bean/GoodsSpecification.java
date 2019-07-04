package com.cskaoyan14th.bean;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsSpecification {
    private Integer id;

    private Integer goodsId;

    private String specification;

    private String value;

    private String pic_url;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    public GoodsSpecification() {
    }

    public GoodsSpecification(Integer id, Integer goodsId, String specifications, String value, String pic_url, Date addTime, Date updateTime, Boolean deleted) {
        this.id = id;
        this.goodsId = goodsId;
        this.specification = specifications;
        this.value = value;
        this.pic_url = pic_url;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecifications() {
        return specification;
    }

    public void setSpecifications(String specifications) {
        this.specification = specifications;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
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

    @Override
    public String toString() {
        return "GoodsSpecification{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", specifications='" + specification + '\'' +
                ", value='" + value + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
