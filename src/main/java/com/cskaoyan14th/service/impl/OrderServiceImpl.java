package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Order;
import com.cskaoyan14th.mapper.OrderMapper;
import com.cskaoyan14th.service.OrderService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:28
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Override
    public Page<Order> queryOrderList(int page, int limit, Short orderStatusArray, String sort, String order, Integer userId, String orderSn) {
        PageHelper.startPage(page, limit);
        List<Order> orderList1 = orderMapper.queryOrderList(orderStatusArray, sort, order, userId, orderSn);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList1);
        Page<Order> orderList = new Page<>(pageInfo.getList(), pageInfo.getTotal());
        return orderList;
    }
}
