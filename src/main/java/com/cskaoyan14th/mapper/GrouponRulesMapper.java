package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.GrouponRules;
import com.cskaoyan14th.bean.GrouponRulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GrouponRulesMapper {
    long countByExample(GrouponRulesExample example);

    int deleteByExample(GrouponRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GrouponRules record);

    int insertSelective(GrouponRules record);

    List<GrouponRules> selectByExample(GrouponRulesExample example);

    List<GrouponRules> selectByGoodsid(@Param("goodsId") int goodsId);

    GrouponRules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GrouponRules record, @Param("example") GrouponRulesExample example);

    int updateByExample(@Param("record") GrouponRules record, @Param("example") GrouponRulesExample example);

    int updateByPrimaryKeySelective(GrouponRules record);

    int updateByPrimaryKey(GrouponRules record);
}