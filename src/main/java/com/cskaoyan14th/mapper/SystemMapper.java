package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.System;
import com.cskaoyan14th.bean.SystemExample;
import java.util.List;

import com.cskaoyan14th.bean.SystemKeyValue;
import org.apache.ibatis.annotations.Param;

public interface SystemMapper {
    long countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);

    String querySystemByKeyValue(@Param("keyName") String keyName);

    int updateSystemKeyValue(@Param("keyValue") String keyValue,@Param("keyName") String keyName);

    String querySystemByFrightMin(@Param("keyName") String keyName);

    int updateSystemByFrightMin(@Param("keyValue") String keyValue,@Param("keyName") String keyName);

    String querySystemByOrder(@Param("keyName") String keyName);

    int updateSystemByOrder(@Param("keyValue") String keyValue,@Param("keyName") String keyName);

    String querySystemByWx(@Param("keyName") String keyName);

    int updateSystemByWx(@Param("keyValue") String keyValue,@Param("keyName") String keyName);



}