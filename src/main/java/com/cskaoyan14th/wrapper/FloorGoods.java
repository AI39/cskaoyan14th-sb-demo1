package com.cskaoyan14th.wrapper;

import com.cskaoyan14th.bean.Goods;

import java.util.List;

public class FloorGoods {

    String name;

    List<Goods> goodsList;

    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
