package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.OrderGoods;
import com.cskaoyan14th.bean.OrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGoodsMapper {
    long countByExample(OrderGoodsExample example);

    int deleteByExample(OrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    List<OrderGoods> selectByExample(OrderGoodsExample example);

    OrderGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByExample(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);

    int deleteOrdergoodsList(int orderId);
}