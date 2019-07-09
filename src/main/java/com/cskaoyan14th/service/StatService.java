package com.cskaoyan14th.service;

import com.cskaoyan14th.wrapper.GoodsStat;
import com.cskaoyan14th.wrapper.OrderStat;
import com.cskaoyan14th.wrapper.UserStat;

import java.util.List;

public interface StatService {
    List<UserStat> getUserStatList();

    List<OrderStat> getOrderStatList();

    List<GoodsStat> getGoodsStatList();
}
