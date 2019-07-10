package com.cskaoyan14th.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-05-20:48
 */
public class OrderDetail {

    private Order order;

    private List<OrderGoods> orderGoods = new ArrayList<>();

    private User user;

    public OrderDetail() {
    }

    public OrderDetail(Order order, List<OrderGoods> orderGoods, User user) {
        this.order = order;
        this.orderGoods = orderGoods;
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order=" + order +
                ", orderGoods=" + orderGoods +
                ", user=" + user +
                '}';
    }
}
