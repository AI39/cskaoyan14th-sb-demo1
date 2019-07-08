package com.cskaoyan14th.vo;

import java.math.BigDecimal;
import java.sql.Date;

public class GoodsStat {
    private int orders;
    private int products;
    private BigDecimal amount;
    private Date day;

    public GoodsStat() {
    }

    public GoodsStat(int orders, int products, BigDecimal amount, Date day) {
        this.orders = orders;
        this.products = products;
        this.amount = amount;
        this.day = day;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "GoodsStat{" +
                "orders=" + orders +
                ", products=" + products +
                ", amount=" + amount +
                ", day=" + day +
                '}';
    }
}
