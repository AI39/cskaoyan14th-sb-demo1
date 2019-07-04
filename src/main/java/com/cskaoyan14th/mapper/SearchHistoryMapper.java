package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.SearchHistory;
import com.cskaoyan14th.bean.SearchHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryMapper {
    long countByExample(SearchHistoryExample example);

    int deleteByExample(SearchHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    List<SearchHistory> selectByExample(SearchHistoryExample example);

    SearchHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchHistory record, @Param("example") SearchHistoryExample example);

    int updateByExample(@Param("record") SearchHistory record, @Param("example") SearchHistoryExample example);

    int updateByPrimaryKeySelective(SearchHistory record);

    int updateByPrimaryKey(SearchHistory record);

    List<SearchHistory> selectSearchHistoryOrder(@Param("sort") String sort, @Param("order") String order);
    List<SearchHistory> selectSearchHistoryOrder(@Param("userId") String userId,@Param("keyword") String keyword,
                                                 @Param("sort") String sort, @Param("order") String order);

}