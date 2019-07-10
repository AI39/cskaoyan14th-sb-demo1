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
import java.util.*;

@Controller
@RequestMapping("wx/cart")
public class CartController {

    @Autowired
    CartService cartService;

    //根据uid返回含有购物车列表cartList和信息cartTotal的Vo
    private ResponseVo<Map<String,Object>> getSuccessListVo(int uid){

        ResponseVo<Map<String,Object>> responseVo = new ResponseVo<>();

        //查找用户购物车，deleted=false，方便让fastadd已经存在购物车的商品不继续加入购物车
        List<Cart> cartList = cartService.getCartListByUidNotDeleted(uid);

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

    /**
     * 订单确认页面
     * @param request
     * @param cartId 0表示购物车订单，1表示立即购买订单
     * @param addressId
     * @param couponId
     * @param grouponRulesId
     * @return
     */
    @RequestMapping("checkout")
    @ResponseBody
    public ResponseVo checkout(HttpServletRequest request,int cartId,int addressId,int couponId,int grouponRulesId){
        //获取token
        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);

        CheckOutOrder checkOutOrder = new CheckOutOrder();

        //商品列表
        List<Cart> checkedGoodsList = new ArrayList<>();
        if (cartId == 0){
            //cartId=0,表示选择购物车内所有被选项
            checkedGoodsList = cartService.getCheckedGoodsList(uid);
        }else {
            //cartId=1,对应“立即购买”按钮，cart表中deleted=1的
            checkedGoodsList = cartService.getFastAddCartByCartId(cartId,uid);
        }


        List<Address> addressList = addressService.getAddressList(uid);
        //Address checkedAddress = addressService.getDefaultAddress(uid);
        Address checkedAddress = addressService.getCheckedAddress(addressId);

        //根据选择商品列表计算总价
        CartTotal cartTotal = CartTotal.calculate(checkedGoodsList);
        double goodsTotalPrice = cartTotal.getCheckedGoodsAmount();

        double couponPrice = couponService.getCouponPrice(couponId);
        /*double couponPrice = 2;*/
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

        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);

        ResponseVo responseVo = new ResponseVo();
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");

        int count = cartService.getGoodsCount(uid);

        responseVo.setData(count);

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
        //同一个用户，同一个productId应该update cart表的number，而不是insert
        int id= cartService.insertCart(cart);

        if (id > 0 ){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }else {
            responseVo.setErrmsg("添加购物车失败");
            responseVo.setErrno(-1);
        }
        int count = cartService.getGoodsCount(uid);
        responseVo.setData(count);
        //responseVo.setData(id);
        return responseVo;
    }

    /**
     * fastadd中，如果购物车没有这个商品，立即购买会生成购物车项
     * 如果有，不增加数目
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("fastadd")
    @ResponseBody
    public ResponseVo fastadd(HttpServletRequest request,@RequestBody Map<String,Object> map){
        Integer goodsId = (Integer) map.get("goodsId");
        Integer number = (Integer) map.get("number");
        Integer productId = (Integer) map.get("productId");
        //获取token
        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);

        //
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

        //！设置true，表示立即购买的商品，区分购物车中的商品
        cart.setDeleted(true);
        int id= cartService.insertFastAddCart(cart);

        ResponseVo responseVo = new ResponseVo();
        //判断用户购物车是否有该商品
        if (id > 0 ){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }else {
            responseVo.setErrmsg("立即购买失败");
            responseVo.setErrno(-1);
        }
        responseVo.setData(id);

        return responseVo;
    }
}
