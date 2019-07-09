package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Coupon;

import java.util.List;


public interface CouponService {
    double getCouponPrice(int couponId);

    List<Coupon> getavailableCouponList(Integer uid);
}
