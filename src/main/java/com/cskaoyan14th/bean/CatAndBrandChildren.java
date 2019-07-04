package com.cskaoyan14th.bean;

public class CatAndBrandChildren {
    Integer value;
    String label;

    public CatAndBrandChildren() {
    }

    public CatAndBrandChildren(Integer value, String label) {
        this.value = value;
        this.label = label;
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

    @Override
    public String toString() {
        return "CatAndBrandChildren{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }
}
