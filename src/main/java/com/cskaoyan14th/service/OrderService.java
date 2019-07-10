package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Order;
import com.cskaoyan14th.bean.OrderDetail;
import com.cskaoyan14th.bean.OrderGoods;
import com.cskaoyan14th.bean.WxOrder;
import com.cskaoyan14th.vo.Page;

import java.util.List;
import java.util.Map;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:27
 */
public interface OrderService {
    Page<Order> queryOrderList(int page, int limit, Short orderStatusArray, String sort, String order, Integer userId, String orderSn);

    OrderDetail showOrderDetail(int id);

    Map<String, Object> queryWxOrderList(int showType, int page, int size);

    /*底下这三个是飞哥写的，用来处理orderList*/

    Map<String, Object> wxQueryOrderListByUserId(int userId, int showType, int page, int size);

    WxOrder queryWxOrderById(int userId);

    List<OrderGoods> queryOrderGoodsById(int orderId);
}
