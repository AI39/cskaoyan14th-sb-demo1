package com.cskaoyan14th.controller.wx;


import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.bean.Coupon;
import com.cskaoyan14th.bean.Order;
import com.cskaoyan14th.service.*;
import com.cskaoyan14th.util.UserTokenManager;

import com.cskaoyan14th.vo.ResponseVo;

import com.cskaoyan14th.wrapper.CartTotal;

import com.cskaoyan14th.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.util.*;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Yuechao Yang
 * @version 2019-07-09-14:36
 */
@RestController
@RequestMapping("/wx/order")
public class WxOrderController {
    @Autowired
    OrderService orderService;
//    @RequestMapping("list")
//    public ResponseMapVo orderList(int showType, int page, int size){
//        ResponseMapVo responseMapVo = new ResponseMapVo();
//        Map<String, Object> data = orderService.queryWxOrderList(showType, page, size);
//        if (data != null){
//            responseMapVo.setData(data);
//            responseMapVo.setErrno(0);
//            responseMapVo.setErrmsg("成功");
//        }else {
//            responseMapVo.setErrno(404);
//            responseMapVo.setErrmsg("失败");
//        }
//        return responseMapVo;
//    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Map<String, Object>> list(Integer showType, Integer page, Integer size, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseVo(-1, new HashMap<String, Object>(), "错误");
        }

        if (showType == null) {                                                //对showType输入为null做特殊处理，有时间建议优化这个处理
            showType = 0;
        }

        Map<String, Object> map = orderService.wxQueryOrderListByUserId(userId, showType, page, size);

        return new ResponseVo<>(0,  map, "成功");
    }

    @RequestMapping("detail")
    @ResponseBody
    public ResponseVo<Map<String, Object>> detail(Integer orderId) {
        Map<String, Object> map = new HashMap<>();

        map.put("orderInfo", orderService.queryWxOrderById(orderId));
        map.put("orderGoods", orderService.queryOrderGoodsById(orderId));
        System.out.println(map);
        return new ResponseVo<>(0,  map, "成功");
    }

    @RequestMapping("prepay")
    @ResponseBody
    public ResponseVo<Object> prepay(@RequestBody Map<String, Object> requestMap){
        return new ResponseVo<>(0,  null, "成功");
    }

<<<<<<< HEAD
    @RequestMapping("delete")
    @ResponseBody
    public ResponseVo<Order> delete(int orderId, HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseVo(-1, null, "错误");
        }
        ResponseVo<Order> responseVo = new ResponseVo<>();
        int delete = orderService.deleteList(orderId);
        if (delete != 0){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }else{
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }
=======
    @Autowired
    AddressService addressService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    CartService cartService;
    @Autowired
    CouponService couponService;
    @RequestMapping("submit")
    @ResponseBody
    public ResponseVo submit(@RequestBody Map<String,Object> map,HttpServletRequest request){
        //获取参数
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(tokenKey);
        Integer addressId = (Integer) map.get("addressId");
        Integer cartId = (Integer) map.get("cartId");
        Integer couponId = (Integer) map.get("couponId");
        Integer grouponLinkId = (Integer) map.get("grouponLinkId");
        Integer grouponRulesId = (Integer) map.get("grouponRulesId");
        String message = (String) map.get("message");
>>>>>>> 87d9c4d5e4e65a8d5e7726240a489b79753f8f60


        /*
        插入order表的操作
         */
        Order order = new Order();
        //设置订单信息
        order.setUserId(uid);
        order.setOrderSn(UUID.randomUUID().toString());
        order.setOrderStatus((short)101);
        //设置收货人信息
        Address address = addressService.getAddressById(addressId);
        order.setConsignee(address.getName());
        order.setMobile(address.getMobile());
        order.setAddress(address.getDetailedAddress());
        order.setMessage(message);

        //设置商品信息
        List<Cart> checkedGoodsList = new ArrayList<>();
        if (cartId == 0){
            checkedGoodsList = cartService.getCheckedGoodsList(uid);
        }else {
            checkedGoodsList = cartService.getFastAddCartByCartId(cartId,uid);
        }
        double goodsPrice = CartTotal.calculate(checkedGoodsList).getCheckedGoodsAmount();
        order.setGoodsPrice(BigDecimal.valueOf(goodsPrice));

        //所以这个邮费在哪里找？
        BigDecimal freightPrice = BigDecimal.valueOf(0);
        order.setFreightPrice(freightPrice);
        
        //优惠券
        Coupon coupon = couponService.getCouponById(couponId);
        BigDecimal couponPrice = null;
        if (coupon != null) {
            couponPrice = coupon.getDiscount();
        }else {
            couponPrice = BigDecimal.valueOf(0);
        }
        order.setCouponPrice(couponPrice);


        //用户积分？wtf?
        BigDecimal integralPrice = BigDecimal.valueOf(0);
        order.setIntegralPrice(integralPrice);

        //团购减免？
        order.setGrouponPrice(BigDecimal.valueOf(0));
        //订单费用， = goods_price + freight_price - coupon_price
        BigDecimal orderPrice = BigDecimal.valueOf(goodsPrice).add(freightPrice).subtract(couponPrice);
        order.setOrderPrice(orderPrice);
        //实付费用， = order_price - integral_price
        BigDecimal actualPrice = orderPrice.subtract(integralPrice);
        order.setActualPrice(actualPrice);

        //....
        order.setEndTime(new Date());
        order.setAddTime(new Date());
        order.setUpdateTime(new Date());
        order.setDeleted(false);

        int orderId = orderService.insertOrderReturnId(order);

        ResponseVo responseVo = new ResponseVo();
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        Map<String,Integer> voMap = new HashMap<>();
        voMap.put("orderId",orderId);
        responseVo.setData(voMap);

        /*
        插入order_goods表的操作
         */


        return responseVo;
    }

}
