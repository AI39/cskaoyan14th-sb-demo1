package com.cskaoyan14th.test;

import com.cskaoyan14th.Cskaoyan14thSbDemo1ApplicationTests;
import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.service.CartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartTest extends Cskaoyan14thSbDemo1ApplicationTests {
    @Autowired
    CartService cartService;
    @Test
    public void test1(){
        List<Cart> cartList = cartService.getCartList(1);
        System.out.println(cartList);
    }
}
