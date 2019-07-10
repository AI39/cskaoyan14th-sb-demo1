package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Keyword;
import com.cskaoyan14th.bean.KeywordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeywordMapper {

    long countByExample(KeywordExample example);

    int deleteByExample(KeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    List<Keyword> selectByExample(KeywordExample example);

    Keyword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Keyword record, @Param("example") KeywordExample example);

    int updateByExample(@Param("record") Keyword record, @Param("example") KeywordExample example);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);

    List<Keyword> queryKeywordList(@Param("keyword") String keyword,@Param("url") String url,@Param("sort") String sort,@Param("order") String order);

    int inserts(Keyword keyword);

    int deleteById(Integer id);
}