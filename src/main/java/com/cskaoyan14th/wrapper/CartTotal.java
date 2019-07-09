package com.cskaoyan14th.wrapper;

import com.cskaoyan14th.bean.Cart;

import java.util.List;

/**
 * 统计订单中商品数目和金额的类
 */
public class CartTotal {
    private int goodsCount;
    private double goodsAmount;
    private int checkedGoodsCount;
    private double checkedGoodsAmount;

    public static CartTotal calculate(List<Cart> cartList) {
        int goodsCount = 0;
        double goodsAmount = 0;
        int checkedGoodsCount = 0;
        double checkedGoodsAmount = 0;
        for (Cart cart : cartList) {
            double price = cart.getPrice().doubleValue();
            int num = cart.getNumber().intValue();
            goodsCount++;
            if (cart.getChecked()){
                checkedGoodsCount++;
                checkedGoodsAmount += price*num;
            }
            goodsAmount += price*num;
        }
        return new CartTotal(goodsCount,goodsAmount,checkedGoodsCount,checkedGoodsAmount);
    }

    @Override
    public String toString() {
        return "CartTotal{" +
                "goodsCount=" + goodsCount +
                ", goodsAmount=" + goodsAmount +
                ", checkedGoodsCount=" + checkedGoodsCount +
                ", checkedGoodsAmount=" + checkedGoodsAmount +
                '}';
    }

    public CartTotal() {
    }

    public CartTotal(int goodsCount, double goodsAmount, int checkedGoodsCount, double checkedGoodsAmount) {
        this.goodsCount = goodsCount;
        this.goodsAmount = goodsAmount;
        this.checkedGoodsCount = checkedGoodsCount;
        this.checkedGoodsAmount = checkedGoodsAmount;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public double getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(int goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public int getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public void setCheckedGoodsCount(int checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public double getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }

    public void setCheckedGoodsAmount(int checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }
}
