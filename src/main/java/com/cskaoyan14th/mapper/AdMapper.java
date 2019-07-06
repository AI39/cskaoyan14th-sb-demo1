package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Ad;
import com.cskaoyan14th.bean.AdExample;
import java.util.List;

import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.apache.ibatis.annotations.Param;

public interface AdMapper {
    long countByExample(AdExample example);

    int deleteByExample(AdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ad record);

    int insertSelective(Ad record);

    List<Ad> selectByExample(AdExample example);

    Ad selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByExample(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);

    List<Ad> selectByName(@Param("name") String name);

    List<Ad> selectByContent(@Param("content") String content);

    List<Ad> selectByNameAndContent(@Param("name")String name,@Param("content") String content);

}