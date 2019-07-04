package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Issue;
import com.cskaoyan14th.bean.IssueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssueMapper {
    long countByExample(IssueExample example);

    int deleteByExample(IssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Issue record);

    int insertSelective(Issue record);

    List<Issue> selectByExample(IssueExample example);

    Issue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByExample(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);

    /*下面是自己定义的方法*/
    List<Issue> queryIssueList(@Param("question") String question, @Param("sort") String sort, @Param("order") String order);       //为什么要加这个

    int deleteById(Integer id);


    Issue selectById(Integer id);
}