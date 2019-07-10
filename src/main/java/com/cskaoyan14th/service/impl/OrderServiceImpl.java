package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.OrderGoodsMapper;
import com.cskaoyan14th.mapper.OrderMapper;
import com.cskaoyan14th.service.OrderService;
import com.cskaoyan14th.util.OrderUtil;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:28
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    OrderMapper orderMapper;
    @Autowired(required = false)
    OrderGoodsMapper orderGoodsMapper;

    @Override
    public Page<Order> queryOrderList(int page, int limit, Short orderStatusArray, String sort, String order, Integer userId, String orderSn) {
        PageHelper.startPage(page, limit);
        List<Order> orderList1 = orderMapper.queryOrderList(orderStatusArray, sort, order, userId, orderSn);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList1);
        Page<Order> orderList = new Page<>(pageInfo.getList(), pageInfo.getTotal());
        return orderList;
    }

    @Override
    public OrderDetail showOrderDetail(int id) {
        OrderDetail orderDetail = orderMapper.showOrderDetail(id);
        return orderDetail;
    }

    @Override
    public Map<String, Object> queryWxOrderList(int showType, int page, int size) {
        PageHelper.startPage(page, size);
        Map<String , Object> wxOrderList = new HashMap<>();
        long count = orderMapper.queryWxOrderListCount();                                                           //符合条件的订单个数
        wxOrderList.put("count", (int)count);
        List<WxOrder> dataByPage = new ArrayList();
        //这里需要往WxOrder中塞数据
        dataByPage = orderMapper.queryDataByPage();

        PageInfo<WxOrder> data = new PageInfo<>(dataByPage);                                                        //把他封装成带页码的data
        wxOrderList.put("data", data);
        int totalPages = (int)(count / size);                                                                       //用来计算页码
        if (count / size != 0){                                                                                     //如果不能整除，页码加一
            totalPages += 1;
        }
        wxOrderList.put("totalPages", totalPages);
        return wxOrderList;
    }

    @Override
    public Map<String, Object> wxQueryOrderListByUserId(int userId, int showType, int page, int size) {
        PageHelper.startPage(page, size);
        List<WxOrder> orderList1 = orderMapper.wxQueryOrderListByUserId(userId, showType);
        System.out.println(orderList1);
        for (WxOrder wxO : orderList1) {
            wxO.setOrderStatusText(OrderUtil.orderStatusText(wxO));
            wxO.setHandleOption(OrderUtil.build(wxO));
        }
        PageInfo<WxOrder> pageInfo = new PageInfo<>(orderList1);

        Map<String, Object> map = new HashMap<>();
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        map.put("totalPages", pageInfo.getPages());
        return map;
    }

    @Override
    public WxOrder queryWxOrderById(int orderId) {
        WxOrder wxOrder = orderMapper.selectWxOrderById(orderId);
        wxOrder.setOrderStatusText(OrderUtil.orderStatusText(wxOrder));
        wxOrder.setHandleOption(OrderUtil.build(wxOrder));

        return wxOrder;
    }

    @Override
    public List<OrderGoods> queryOrderGoodsById(int orderId) {
        OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
        OrderGoodsExample.Criteria criteria = orderGoodsExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderGoods> orderGoodsList = orderGoodsMapper.selectByExample(orderGoodsExample);

        return orderGoodsList;
    }
}
