package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.bean.CartExample;
import com.cskaoyan14th.mapper.CartMapper;
import com.cskaoyan14th.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> getCartList(Integer uid) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(uid);
        return cartMapper.selectByExample(example);
    }
}
