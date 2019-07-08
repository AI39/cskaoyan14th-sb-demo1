package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.mapper.StatMapper;
import com.cskaoyan14th.service.StatService;
import com.cskaoyan14th.vo.GoodsStat;
import com.cskaoyan14th.vo.OrderStat;
import com.cskaoyan14th.vo.UserStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatServiceImpl implements StatService {
    @Autowired(required = false)
    StatMapper statMapper;

    @Override
    public List<UserStat> getUserStatList() {
        return statMapper.getUserStatList();
    }

    @Override
    public List<OrderStat> getOrderStatList() {
        return statMapper.getOrderStatList();
    }

    @Override
    public List<GoodsStat> getGoodsStatList() {
        return statMapper.getGoodsStatList();
    }
}
