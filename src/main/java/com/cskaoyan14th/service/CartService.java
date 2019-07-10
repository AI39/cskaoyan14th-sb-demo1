package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.bean.OrderGoods;

import java.util.List;

public interface CartService {
    @Deprecated
    List<Cart> getCartList(Integer uid);

    int updateCartChecked(int uid, int isChecked, List<Integer> productIds);

    int updateCartNumber(Integer id, Integer goodsId, Integer productId, Integer number);
    int updateCartNumber(Integer id, Integer number);

    int deleteCartItemByPids(Integer uid, List<Integer> productIds);

    //获取购物车选中的cart，deleted=0
    List<Cart> getCheckedGoodsList(Integer uid);

    //同一个用户，同一个productId应该update cart表的number，而不是insert
    int insertCart(Cart cart);
    //立即购买的商品，购物车项deleted=true
    int insertFastAddCart(Cart deletedCart);

    //通过cartId获取一个Cart，立即购买
    List<Cart> getFastAddCartByCartId(int cartId, Integer uid);

    //统计购物车商品数量
    int getGoodsCount(Integer uid);

    //根据uid查找购物车
    List<Cart> getCartListByUidNotDeleted(int uid);


    int setDeletedTrueById(Integer id);
}
