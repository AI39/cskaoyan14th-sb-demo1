package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.bean.OrderGoods;

import java.util.List;

public interface CartService {
    List<Cart> getCartList(Integer uid);

    int updateCartChecked(int uid, int isChecked, List<Integer> productIds);

    int updateCartNumber(Integer id, Integer goodsId, Integer productId, Integer number);
    int updateCartNumber(Integer id, Integer number);

    int deleteCartItemByPids(Integer uid, List<Integer> productIds);

    List<Cart> getCheckedGoodsList(Integer uid);
}
