package com.cskaoyan14th.wrapper;

import com.cskaoyan14th.bean.Ad;
import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.bean.Goods;

import java.util.List;

/**
 *
 */
public class CheckOutOrder {
    //实付
    private double actualPrice;
    //地址数量
    private int addressId;
    //优惠券数量
    private int availeCouponLength;

    private Address checkedAddress;

    private List<Cart> checkedGoodsList;
    //优惠券id和价格
    private int couponId;

    private double couponPrice;
    //运费
    private double freightPrice;
    //商品合计
    private double goodsTotalPrice;
    //团购价
    private double grouponPrice;
    private int grouponRulesId;
    //订单价格，应该是跟实付一个价
    private double orderTotalPrice;


    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAvaileCouponLength() {
        return availeCouponLength;
    }

    public void setAvaileCouponLength(int availeCouponLength) {
        this.availeCouponLength = availeCouponLength;
    }

    public Address getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(Address checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public List<Cart> getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(List<Cart> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public double getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(double grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
}
