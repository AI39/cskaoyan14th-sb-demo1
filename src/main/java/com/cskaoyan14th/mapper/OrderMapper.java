package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Order;
import com.cskaoyan14th.bean.OrderDetail;
import com.cskaoyan14th.bean.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> queryOrderList(@Param("orderStatusArray") Short orderStatusArray,@Param("sort") String sort,@Param("order") String order,@Param("userId") Integer userId,@Param("orderSn") String orderSn);

    OrderDetail showOrderDetail(int id);
}