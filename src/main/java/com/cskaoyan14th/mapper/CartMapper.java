package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Cart;
import com.cskaoyan14th.bean.CartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMapper {

    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    int updateCheckedByUidAndPids(@Param("uid") int uid,@Param("isChecked") int isChecked,@Param("productIds") List<Integer> productIds);

    int updateCartNumber(@Param("id") Integer id, @Param("number") Integer number);

    int updateCartNumber2(@Param("id") Integer id,@Param("goodsId") Integer goodsId,
                         @Param("productId") Integer productId,@Param("number") Integer number);

    int deleteCartItemByPids(@Param("uid") Integer uid,@Param("productIds") List<Integer> productIds);

    //获取选中的购物车项，deleted=0
    List<Cart> getCheckedCartList(@Param("uid") Integer uid);

    int insertCartReturnId(Cart cart);

    List<Cart> getCartItemByCartId(@Param("cartId") int cartId,@Param("uid") Integer uid);

    int getCartCountByUid(Integer uid);

    //根据cartid查询商品数量
    int queryNumberById(@Param("id") Integer id);

    //查询数据库中是否有该uid和productId的数据
    Cart queryCartWithUidAndPid(@Param("uid") Integer userId,@Param("pid") Integer productId);

    //只查deleted=0的购物车项
    List<Cart> getCartListByUidNotDeleted(@Param("uid") int uid);

    void clearDeletedCart(@Param("uid") Integer userId);

    int setDeletedTrueById(@Param("id") Integer id);
}