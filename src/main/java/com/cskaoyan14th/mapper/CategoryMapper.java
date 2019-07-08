package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Category;
import com.cskaoyan14th.bean.CategoryExample;
import java.util.List;

import com.cskaoyan14th.bean.CategoryForGoods;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<CategoryForGoods> queryCategoryL1();

    List<Category> queryCategoryList();

    Category selectById(@Param("id") Integer id);

    int inserts(Category category);

    int deleteCategory(Category category);

    int deleteCategoryById(Category category);

    int deleteCategoryByPid(Category category);
}