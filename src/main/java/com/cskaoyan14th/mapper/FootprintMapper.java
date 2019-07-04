package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Footprint;
import com.cskaoyan14th.bean.FootprintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FootprintMapper {
    long countByExample(FootprintExample example);

    int deleteByExample(FootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    List<Footprint> selectByExample(FootprintExample example);

    Footprint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByExample(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    List<Footprint> selectFootprintListOrder(String sort, String order);
    List<Footprint> selectFootprintListOrder(@Param("userId") String userId,@Param("goodsId") String goodsId,
                                             @Param("sort") String sort, @Param("order") String order);

}