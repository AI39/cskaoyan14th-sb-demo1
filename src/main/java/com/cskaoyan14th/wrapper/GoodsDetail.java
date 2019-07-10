package com.cskaoyan14th.wrapper;

import com.cskaoyan14th.bean.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodsDetail {

    private List<Map<String, Object>> specificationList = new ArrayList<>();

    private List<GrouponRules> groupon;

    private List<Issue> issue;

    private int userHasCollect;

    private String shareImage;

    private Map<String, Object> comment;

    private List<GoodsAttribute> attribute;

    private Brand brand;

    private List<GoodsProduct> productList;

    private Goods info;

    public List<Map<String, Object>> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<Map<String, Object>> specificationList) {
        this.specificationList = specificationList;
    }

    public List<GrouponRules> getGroupon() {
        return groupon;
    }

    public void setGroupon(List<GrouponRules> groupon) {
        this.groupon = groupon;
    }

    public List<Issue> getIssue() {
        return issue;
    }

    public void setIssue(List<Issue> issue) {
        this.issue = issue;
    }

    public int getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(int userHasCollect) {
        this.userHasCollect = userHasCollect;
    }

    public String getShareImage() {
        return shareImage;
    }

    public void setShareImage(String shareImage) {
        this.shareImage = shareImage;
    }

    public Map<String, Object> getComment() {
        return comment;
    }

    public void setComment(Map<String, Object> comment) {
        this.comment = comment;
    }

    public List<GoodsAttribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<GoodsAttribute> attribute) {
        this.attribute = attribute;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<GoodsProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<GoodsProduct> productList) {
        this.productList = productList;
    }

    public Goods getInfo() {
        return info;
    }

    public void setInfo(Goods info) {
        this.info = info;
    }
}
