package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.*;
import com.cskaoyan14th.wrapper.CartTotal;
import com.cskaoyan14th.util.UserTokenManager;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.wrapper.CheckOutOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wx/cart")
public class CartController {

    @Autowired
    CartService cartService;

    //根据uid返回含有购物车列表cartList和信息cartTotal的Vo
    private ResponseVo<Map<String,Object>> getSuccessListVo(int uid){
        ResponseVo<Map<String,Object>> responseVo = new ResponseVo<>();

        List<Cart> cartList = cartService.getCartList(uid);

        CartTotal cartTotal = CartTotal.calculate(cartList);
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("cartList",cartList);
        objectMap.put("cartTotal",cartTotal);
        responseVo.setData(objectMap);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }
    @RequestMapping("index")
    @ResponseBody
    public ResponseVo<Map<String,Object>> index(HttpServletRequest request){
        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);
        return getSuccessListVo(uid);
    }

    @RequestMapping("checked")
    @ResponseBody
    public ResponseVo<Map<String,Object>> checked(@RequestBody Map<String,Object> map,HttpServletRequest request){
        //获取请求json对象的信息
        Integer isChecked = (Integer) map.get("isChecked");
        List<Integer> productIds = (List<Integer>) map.get("productIds");
        //获取token
        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);

        int update = cartService.updateCartChecked(uid,isChecked,productIds);

        if (update > 0){
            return getSuccessListVo(uid);
        }else {
            return new ResponseVo(-1,null,"服务器异常");
        }
    }

    @RequestMapping("update")
    @ResponseBody
    public ResponseVo update(@RequestBody Map<String,Object> map,HttpServletRequest request){
        Integer goodsId = (Integer) map.get("goodsId");
        Integer id = (Integer) map.get("id");
        Integer number = (Integer) map.get("number");
        Integer productId = (Integer) map.get("productId");

        //获取token
        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);

        int update = cartService.updateCartNumber(id,number);
        if (update > 0){
            return new ResponseVo(0,null,"成功");
        }else {
            return new ResponseVo(-1,null,"服务器异常");
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseVo delete(@RequestBody Map<String,Object> map,HttpServletRequest request){
        List<Integer> productIds = (List<Integer>) map.get("productIds");

        //获取token
        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);

        int delete = cartService.deleteCartItemByPids(uid,productIds);
        if (delete > 0){
            return getSuccessListVo(uid);
        }else {
            return new ResponseVo(-1,null,"服务器异常");
        }

    }

    @Autowired
    CouponService couponService;
    @Autowired
    GrouponRulesService grouponRulesService;
    @Autowired
    AddressService addressService;
    @RequestMapping("checkout")
    @ResponseBody
    public ResponseVo checkout(HttpServletRequest request,int cartId,int addressId,int couponId,int grouponRulesId){
        //获取token
        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);

        CheckOutOrder checkOutOrder = new CheckOutOrder();

        List<Cart> checkedGoodsList = cartService.getCheckedGoodsList(uid);
        List<Address> addressList = addressService.getAddressList(uid);
        //Address checkedAddress = addressService.getDefaultAddress(uid);
        Address checkedAddress = addressService.getCheckedAddress(addressId);

        CartTotal cartTotal = CartTotal.calculate(checkedGoodsList);
        double goodsTotalPrice = cartTotal.getCheckedGoodsAmount();

        //double couponPrice = couponService.getCouponPrice(couponId);
        double couponPrice = 2;
        //int availableCouponLength = couponService.getavailableCouponList(uid).size();
        int availableCouponLength = 5;

        double freightPrice = 0;

        //double grouponPrice = grouponRulesService.getGrouponPrice(grouponRulesId);
        double grouponPrice = 1;
        //actualPrice = orderPrice
        double actualPrice = goodsTotalPrice - couponPrice + freightPrice;

        checkOutOrder.setAddressId(addressId);
        checkOutOrder.setCheckedAddress(checkedAddress);//待
        checkOutOrder.setGoodsTotalPrice(goodsTotalPrice);
        checkOutOrder.setCheckedGoodsList(checkedGoodsList);
        checkOutOrder.setAvaileCouponLength(availableCouponLength);
        checkOutOrder.setCouponId(couponId);
        checkOutOrder.setCouponPrice(couponPrice);
        checkOutOrder.setFreightPrice(freightPrice);
        checkOutOrder.setGrouponRulesId(grouponRulesId);
        checkOutOrder.setGrouponPrice(grouponPrice);
        checkOutOrder.setActualPrice(actualPrice);
        checkOutOrder.setOrderTotalPrice(actualPrice);

        ResponseVo<CheckOutOrder> responseVo = new ResponseVo<>();
        responseVo.setData(checkOutOrder);
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;

    }

    @RequestMapping("goodscount")
    @ResponseBody
    public ResponseVo goodsCount(HttpServletRequest request){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(0);
        return responseVo;
    }

    @Autowired
    GoodsService goodsService;

    @RequestMapping("add")
    @ResponseBody
    public ResponseVo add(@RequestBody Map<String,Object> map,HttpServletRequest request){
        Integer goodsId = (Integer) map.get("goodsId");
        Integer number = (Integer) map.get("number");
        Integer productId = (Integer) map.get("productId");
        //获取token
        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);

        Cart cart = new Cart();
        cart.setUserId(uid);

        //通过goods_id获取商品，需要goods_sn和goods_name
        cart.setGoodsId(goodsId);
        Goods goods = goodsService.getGoodByGoodsId(goodsId);
        cart.setGoodsName(goods.getName());
        cart.setGoodsSn(goods.getGoodsSn());

        //通过product_id获取商品货物表goods_product的信息
        cart.setProductId(productId);
        GoodsProduct product = goodsService.getProductByProductId(productId);
        cart.setPrice(product.getPrice());
        cart.setNumber(number.shortValue());

        String[] specifications = product.getSpecifications();
        StringBuilder sb = new StringBuilder();
        for (String specification : specifications) {
            sb.append(specification);
        }
        cart.setSpecifications(sb.toString());

        //数据库里是tinyint ,bean里是boolean
        cart.setChecked(true);
        cart.setPicUrl(goods.getPicUrl());
        cart.setAddTime(new Date());
        cart.setUpdateTime(new Date());
        cart.setDeleted(false);

        ResponseVo responseVo = new ResponseVo();
        //插入cart
        int id= cartService.insertCart(cart);
        if (id > 0 ){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }else {
            responseVo.setErrmsg("添加购物车失败");
            responseVo.setErrno(-1);
        }
        responseVo.setData(id);
        return responseVo;
    }
}
