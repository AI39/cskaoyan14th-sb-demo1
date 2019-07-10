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

    List<Cart> getCheckedCartList(@Param("uid") Integer uid);

    int insertCartReturnId(Cart cart);
}