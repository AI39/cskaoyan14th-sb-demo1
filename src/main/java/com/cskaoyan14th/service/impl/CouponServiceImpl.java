package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Coupon;
import com.cskaoyan14th.bean.CouponExample;
import com.cskaoyan14th.mapper.CouponMapper;
import com.cskaoyan14th.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;

    @Override
    public double getCouponPrice(int couponId) {

        Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
        return coupon.getDiscount().doubleValue();
    }

    @Override
    public List<Coupon> getavailableCouponList(Integer uid) {
/*        CouponExample example = new CouponExample();
        CouponExample.Criteria criteria = example.createCriteria();
        couponMapper.selectByExample()*/
        //这里可能还要连表，coupon和coupon_user表。。。

        return couponMapper.selectAllCoupon();
    }

    @Override
    public Coupon getCouponById(Integer couponId) {
        return couponMapper.selectByPrimaryKey(couponId);
    }
}
