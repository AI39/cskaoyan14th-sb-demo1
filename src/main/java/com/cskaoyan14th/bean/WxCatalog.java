package com.cskaoyan14th.bean;

import com.cskaoyan14th.bean.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-08-20:17
 */
public class WxCatalog {

    private List<Category> categoryList = new ArrayList<>();

    private Category currentCategory;

    private List<Category> currentSubCategory = new ArrayList<>();

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<Category> getCurrentSubCategory() {
        return currentSubCategory;
    }

    public void setCurrentSubCategory(List<Category> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }

    public WxCatalog(List<Category> categoryList, Category currentCategory, List<Category> currentSubCategory) {
        this.categoryList = categoryList;
        this.currentCategory = currentCategory;
        this.currentSubCategory = currentSubCategory;
    }

    public WxCatalog() {
    }

    @Override
    public String toString() {
        return "WxCatalog{" +
                "categoryList=" + categoryList +
                ", currentCategory=" + currentCategory +
                ", currentSubCategory=" + currentSubCategory +
                '}';
    }
}
