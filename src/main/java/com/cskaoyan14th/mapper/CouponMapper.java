package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Coupon;
import com.cskaoyan14th.bean.CouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponMapper {
    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);

    List<Coupon> selectAllCoupon();

    List<Coupon> selectSomeCoupon(@Param("name") String name,@Param("type") short type,@Param("status") short status);

    List<Coupon> selectCouponByName(@Param("name") String name);

    List<Coupon> selectCouponByType(@Param("type") short type);

    List<Coupon> selectCouponByStatus(@Param("status") short status);

    List<Coupon> selectCouponByNameAndType(@Param("name") String name,@Param("type") short type);

    List<Coupon> selectCouponByNameAndStatus(@Param("name") String name,@Param("status") short status);

    List<Coupon> selectCouponByTypeAndStatus(@Param("type") short type,@Param("status")short status);

    Coupon selectCouponByCode(@Param("code") String code);
}