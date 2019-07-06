package com.cskaoyan14th.vo;

import java.math.BigDecimal;
import java.sql.Date;

public class OrderStat {
    private BigDecimal amount;
    private int customers;
    private Date day;
    private int orders;
    private BigDecimal pcr;

    public OrderStat() {
    }

    public OrderStat(BigDecimal amount, int customers, Date day, int orders, BigDecimal pcr) {
        this.amount = amount;
        this.customers = customers;
        this.day = day;
        this.orders = orders;
        this.pcr = pcr;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public BigDecimal getPcr() {
        return pcr;
    }

    public void setPcr(BigDecimal pcr) {
        this.pcr = pcr;
    }

    @Override
    public String toString() {
        return "OrderStat{" +
                "amount=" + amount +
                ", customers=" + customers +
                ", day=" + day +
                ", orders=" + orders +
                ", pcr=" + pcr +
                '}';
    }
}
