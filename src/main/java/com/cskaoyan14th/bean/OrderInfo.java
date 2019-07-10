package com.cskaoyan14th.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {

    String consignee;

    String address;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    Date addTime;


    String orderSn;

    BigDecimal actualPrice;

    String mobile;

    String expCode;//order里的shipChannel

    String orderStatusText;

    BigDecimal goodsPrice;

    String expNo;//order里的shipSn

    int id;

    BigDecimal freightPrice;

    HandleOption handleOption;

    public OrderInfo() {
    }

    public OrderInfo(String consignee, String address, Date addTime, String orderSn, BigDecimal actualPrice, String mobile, String expCode, String orderStatusText, BigDecimal goodsPrice, String expNo, int id, BigDecimal freightPrice, HandleOption handleOption) {
        this.consignee = consignee;
        this.address = address;
        this.addTime = addTime;
        this.orderSn = orderSn;
        this.actualPrice = actualPrice;
        this.mobile = mobile;
        this.expCode = expCode;
        this.orderStatusText = orderStatusText;
        this.goodsPrice = goodsPrice;
        this.expNo = expNo;
        this.id = id;
        this.freightPrice = freightPrice;
        this.handleOption = handleOption;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExpCode() {
        return expCode;
    }

    public void setExpCode(String expCode) {
        this.expCode = expCode;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getExpNo() {
        return expNo;
    }

    public void setExpNo(String expNo) {
        this.expNo = expNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }
}
