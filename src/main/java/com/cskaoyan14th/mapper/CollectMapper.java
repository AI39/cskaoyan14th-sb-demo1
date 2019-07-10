package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Collect;
import com.cskaoyan14th.bean.CollectExample;
import com.cskaoyan14th.wrapper.CollectData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    List<Collect> selectCollectListOrder(@Param("userId") String userId,@Param("valueId") String valueId,
                                         @Param("sort") String sort, @Param("order") String order);

    List<CollectData> selectCollectDataListByUserId(@Param("userId") int userId, @Param("type") int type);

}