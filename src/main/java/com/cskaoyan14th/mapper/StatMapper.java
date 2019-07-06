package com.cskaoyan14th.mapper;

import com.cskaoyan14th.vo.GoodsStat;
import com.cskaoyan14th.vo.OrderStat;
import com.cskaoyan14th.vo.UserStat;

import java.util.List;

public interface StatMapper {
    List<UserStat> getUserStatList();

    List<OrderStat> getOrderStatList();

    List<GoodsStat> getGoodsStatList();
}
