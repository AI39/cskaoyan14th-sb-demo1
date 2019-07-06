package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Order;
import com.cskaoyan14th.bean.OrderDetail;
import com.cskaoyan14th.vo.Page;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:27
 */
public interface OrderService {
    Page<Order> queryOrderList(int page, int limit, Short orderStatusArray, String sort, String order, Integer userId, String orderSn);

    OrderDetail showOrderDetail(int id);
}
