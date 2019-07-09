package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartList(Integer uid);
}
