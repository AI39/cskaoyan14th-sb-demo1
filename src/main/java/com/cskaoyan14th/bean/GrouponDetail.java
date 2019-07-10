package com.cskaoyan14th.bean;

public class GrouponDetail {
    Creator creator;
    Groupon groupon;
    Creator[] joiners;
    OrderInfo orderInfo;
    OrderGoods[] orderGoods;
    GrouponRules rules;
    int linkGrouponId;

    public GrouponDetail() {
    }

    public GrouponDetail(Creator creator, Groupon groupon, Creator[] joiners, OrderInfo orderInfo, OrderGoods[] orderGoods, GrouponRules rules, int linkGrouponId) {
        this.creator = creator;
        this.groupon = groupon;
        this.joiners = joiners;
        this.orderInfo = orderInfo;
        this.orderGoods = orderGoods;
        this.rules = rules;
        this.linkGrouponId = linkGrouponId;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public Creator[] getJoiners() {
        return joiners;
    }

    public void setJoiners(Creator[] joiners) {
        this.joiners = joiners;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public OrderGoods[] getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(OrderGoods[] orderGoods) {
        this.orderGoods = orderGoods;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }

    public int getLinkGrouponId() {
        return linkGrouponId;
    }

    public void setLinkGrouponId(int linkGrouponId) {
        this.linkGrouponId = linkGrouponId;
    }
}
