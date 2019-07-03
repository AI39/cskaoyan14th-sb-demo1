package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Collect;
import com.cskaoyan14th.bean.CollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectMapper {
    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<Collect> selectCollectListOrder(String sort, String order);
}