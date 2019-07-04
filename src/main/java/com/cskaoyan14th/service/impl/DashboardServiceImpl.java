package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.GoodsExample;
import com.cskaoyan14th.bean.GoodsProductExample;
import com.cskaoyan14th.bean.OrderExample;
import com.cskaoyan14th.bean.UserExample;
import com.cskaoyan14th.mapper.*;
import com.cskaoyan14th.service.DashboardService;
import com.cskaoyan14th.vo.Total;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired(required = false)
    GoodsMapper goodsMapper;

    @Autowired(required = false)
    OrderMapper orderMapper;

    @Autowired(required = false)
    GoodsProductMapper goodsProductMapper;

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public Total getTotal() {
        //查询商品数量
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria();
        long goodsTotal = goodsMapper.countByExample(goodsExample);
        //查询订单数量
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria orderCriteria = orderExample.createCriteria();
        long orderTotal = orderMapper.countByExample(orderExample);
        //查询货品数量
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        GoodsProductExample.Criteria goodsProductCriteria = goodsProductExample.createCriteria();
        long goodsProductTotal = goodsProductMapper.countByExample(goodsProductExample);
        //查询用户数量
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        long userTotal = userMapper.countByExample(userExample);
        //封装成Total类型
        Total total = new Total();
        total.setGoodsTotal((int)goodsTotal);
        total.setOrderTotal((int)orderTotal);
        total.setProductTotal((int)goodsProductTotal);
        total.setUserTotal((int)userTotal);

        return total;
    }
}
