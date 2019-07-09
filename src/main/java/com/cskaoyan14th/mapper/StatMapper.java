package com.cskaoyan14th.mapper;

import com.cskaoyan14th.wrapper.GoodsStat;
import com.cskaoyan14th.wrapper.OrderStat;
import com.cskaoyan14th.wrapper.UserStat;

import java.util.List;

public interface StatMapper {
    List<UserStat> getUserStatList();

    List<OrderStat> getOrderStatList();

    List<GoodsStat> getGoodsStatList();
}
