package com.cskaoyan14th.bean;

import java.util.List;

public class MyGroupon {
    String orderStatusText;
    String creator;
    Groupon groupon;
    int orderId;
    String orderSn;
    double actualPrice;
    int joinerCount;
    List<Goods> goodsList;
    GrouponRules rules;
    int id;
    boolean isCreator;
    HandleOption handleOption;

    public MyGroupon() {
    }

    public MyGroupon(String orderStatusText, String creator, Groupon groupon, int orderId, String orderSn, double actualPrice, int joinerCount, List<Goods> goodsList, GrouponRules rules, int id, boolean isCreator, HandleOption handleOption) {
        this.orderStatusText = orderStatusText;
        this.creator = creator;
        this.groupon = groupon;
        this.orderId = orderId;
        this.orderSn = orderSn;
        this.actualPrice = actualPrice;
        this.joinerCount = joinerCount;
        this.goodsList = goodsList;
        this.rules = rules;
        this.id = id;
        this.isCreator = isCreator;
        this.handleOption = handleOption;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getJoinerCount() {
        return joinerCount;
    }

    public void setJoinerCount(int joinerCount) {
        this.joinerCount = joinerCount;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = creator;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }
}
