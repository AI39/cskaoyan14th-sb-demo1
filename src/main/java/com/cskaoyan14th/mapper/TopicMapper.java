package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Topic;
import com.cskaoyan14th.bean.TopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicMapper {
    long countByExample(TopicExample example);

    int deleteByExample(TopicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    List<Topic> selectByExampleWithBLOBs(TopicExample example);

    List<Topic> selectByExample(TopicExample example);

    Topic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExampleWithBLOBs(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExample(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> selectByTitleAndSubtitle(@Param("title") String title,@Param("subtitle") String subtitle);

    List<Topic> selectByTitle(@Param("title")String title);

    List<Topic> selectBySubtitle(@Param("subtitle")String subtitle);

    List<Topic> selectRelatedTopic(@Param("id") int id);
}