package com.cskaoyan14th.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryForGoods {
    Integer value;
    String label;
    List<CatAndBrandChildren> children = new ArrayList<>();

    public CategoryForGoods() {
    }

    public CategoryForGoods(Integer value, String label, List<CatAndBrandChildren> children) {
        this.value = value;
        this.label = label;
        this.children = children;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<CatAndBrandChildren> getChildren() {
        return children;
    }

    public void setChildren(List<CatAndBrandChildren> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "CategoryForGoods{" +
                "value=" + value +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
