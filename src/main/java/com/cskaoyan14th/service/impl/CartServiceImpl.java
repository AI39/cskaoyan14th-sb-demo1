package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.bean.CartExample;
import com.cskaoyan14th.mapper.CartMapper;
import com.cskaoyan14th.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
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
        int insert = cartMapper.insertCartReturnId(cart);
        if (insert > 0){
            return cart.getId();
        }else {
            return insert;
        }
    }
}
