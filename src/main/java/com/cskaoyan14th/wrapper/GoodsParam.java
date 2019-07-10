package com.cskaoyan14th.wrapper;

import com.cskaoyan14th.bean.Goods;
import com.cskaoyan14th.bean.GoodsAttribute;
import com.cskaoyan14th.bean.GoodsProduct;
import com.cskaoyan14th.bean.GoodsSpecification;

public class GoodsParam {

    int[] categoryIds;

    Goods goods;

    GoodsSpecification[] specifications;

    GoodsProduct[] products;

    GoodsAttribute[] attributes;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(GoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public GoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(GoodsProduct[] products) {
        this.products = products;
    }

    public GoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(GoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

    public int[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(int[] categoryIds) {
        this.categoryIds = categoryIds;
    }
}
