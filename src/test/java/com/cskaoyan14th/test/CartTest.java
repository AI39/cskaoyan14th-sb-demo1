package com.cskaoyan14th.test;

import com.cskaoyan14th.Cskaoyan14thSbDemo1ApplicationTests;
import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.service.CartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CartTest extends Cskaoyan14thSbDemo1ApplicationTests {
    @Autowired
    CartService cartService;
    @Test
    public void test1(){
        List<Cart> cartList = cartService.getCartList(1);
        System.out.println(cartList);
    }

    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i = cartService.updateCartChecked(1, 0, list);
        System.out.println(i);
    }
}
