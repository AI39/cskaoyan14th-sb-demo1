package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.bean.CartExample;
import com.cskaoyan14th.mapper.CartMapper;
import com.cskaoyan14th.service.CartService;
import com.cskaoyan14th.wrapper.CartTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;


    @Override
    @Deprecated
    public List<Cart> getCartList(Integer uid) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(uid);
        return cartMapper.selectByExample(example);
    }

    @Override
    public int updateCartChecked(int uid, int isChecked, List<Integer> productIds) {
        return cartMapper.updateCheckedByUidAndPids(uid,isChecked,productIds);
    }

    @Override
    public int updateCartNumber(Integer id, Integer goodsId, Integer productId, Integer number) {
        return cartMapper.updateCartNumber2(id,goodsId,productId,number);
    }

    @Override
    public int updateCartNumber(Integer id, Integer number) {
        return cartMapper.updateCartNumber(id,number);
    }

    @Override
    public int deleteCartItemByPids(Integer uid, List<Integer> productIds) {
        return cartMapper.deleteCartItemByPids(uid,productIds);
    }

    @Override
    public List<Cart> getCheckedGoodsList(Integer uid) {
        return cartMapper.getCheckedCartList(uid);
    }

    /**
     * 插入并返回id
     * @param cart
     * @return
     */
    @Override
    public int insertCart(Cart cart) {
        //查询数据库中是否有相同uid和productid的记录
        Cart oldCart = cartMapper.queryCartWithUidAndPid(cart.getUserId(),cart.getProductId());
        if (oldCart != null){
            //有相同的记录，先获取原先的number，再跟新number
            int oldNum = cartMapper.queryNumberById(oldCart.getId());
            int update = cartMapper.updateCartNumber(oldCart.getId(), cart.getNumber() + oldNum);
            return update;
        }
        //否则插入新记录，并返回插入新数据的id
        int insert = cartMapper.insertCartReturnId(cart);
        if (insert > 0){
            return cart.getId();
        }else {
            return insert;
        }
    }

    //立即购买
    @Override
    public List<Cart> getFastAddCartByCartId(int cartId, Integer uid) {
        return cartMapper.getCartItemByCartId(cartId,uid);
    }

    @Override
    public int getGoodsCount(Integer uid) {
        List<Cart> cartListByUidNotDeleted = cartMapper.getCartListByUidNotDeleted(uid);
        return CartTotal.calculate(cartListByUidNotDeleted).getGoodsCount();
    }

    @Override
    public List<Cart> getCartListByUidNotDeleted(int uid) {
        return cartMapper.getCartListByUidNotDeleted(uid);
    }

    @Override
    public int setDeletedTrueById(Integer id) {
        return cartMapper.setDeletedTrueById(id);
    }

    /**
     * 立即购买的插入，deleted=true
     * @param deletedCart
     * @return
     */
    @Override
    public int insertFastAddCart(Cart deletedCart) {
        //先删除之前该用户的deleted=true的购物项
        cartMapper.clearDeletedCart(deletedCart.getUserId());
        //插入新的立即购买的项
        deletedCart.setDeleted(true);
        int deletedId = cartMapper.insertCartReturnId(deletedCart);
        if (deletedId == 1){
            //取得插入的id
            deletedId = deletedCart.getId();
        }else {
            deletedId = -1;
        }
        //原购物车如果没有该商品，再添加一个deleted=0的相同项
        Cart notDeletedCart = cartMapper.queryCartWithUidAndPid(deletedCart.getUserId(),deletedCart.getProductId());
        if (notDeletedCart == null){
            deletedCart.setDeleted(false);
            int insert = cartMapper.insertCartReturnId(deletedCart);
        }

        return deletedId;
    }
}
