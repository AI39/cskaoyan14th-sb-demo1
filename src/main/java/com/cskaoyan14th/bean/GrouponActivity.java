package com.cskaoyan14th.bean;

import java.util.Arrays;

public class GrouponActivity {
    Groupon groupon;
    Goods goods;
    GrouponRules rules;
    String[] subGroupons;

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }

    public String[] getSubGroupons() {
        return subGroupons;
    }

    public void setSubGroupons(String[] subGroupons) {
        this.subGroupons = subGroupons;
    }

    @Override
    public String toString() {
        return "GrouponActivity{" +
                "groupon=" + groupon +
                ", goods=" + goods +
                ", rules=" + rules +
                ", subGroupons=" + Arrays.toString(subGroupons) +
                '}';
    }
}
