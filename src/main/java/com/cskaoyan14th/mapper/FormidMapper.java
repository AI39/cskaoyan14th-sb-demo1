package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Formid;
import com.cskaoyan14th.bean.FormidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FormidMapper {

    long countByExample(FormidExample example);

    int deleteByExample(FormidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Formid record);

    int insertSelective(Formid record);

    List<Formid> selectByExample(FormidExample example);

    Formid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Formid record, @Param("example") FormidExample example);

    int updateByExample(@Param("record") Formid record, @Param("example") FormidExample example);

    int updateByPrimaryKeySelective(Formid record);

    int updateByPrimaryKey(Formid record);
}