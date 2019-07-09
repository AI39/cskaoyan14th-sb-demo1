package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Category;
import com.cskaoyan14th.bean.CategoryForGoods;
import com.cskaoyan14th.bean.wx.Catalog;
import com.cskaoyan14th.mapper.CategoryMapper;
import com.cskaoyan14th.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:23
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<CategoryForGoods> queryCategoryL1() {
        List<CategoryForGoods> categoryL1 = categoryMapper.queryCategoryL1();
        return categoryL1;
    }

    @Override
    public List<Category> queryCategoryList() {
        List<Category> categoryList = categoryMapper.queryCategoryList();
        return categoryList;
    }

    @Override
    public int updateCategory(Category category) {
        int i = categoryMapper.updateByPrimaryKey(category);
        return i;
    }

    @Override
    public Category createCategory(Category category) {
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        category.setAddTime(date);
        category.setUpdateTime(date);
        categoryMapper.inserts(category);
        Category category1 = categoryMapper.selectById(category.getId());
        return category1;
    }

    @Override
    public int deleteCategory(Category category) {
       int delete = categoryMapper.deleteCategory(category);
        return delete;

    }

    @Override
    public Catalog queryCatalogIndex() {
        List<Category> categoryList = categoryMapper.queryCatalogIndex();                                           //取到一级目录
        Category categoryFirst = categoryList.get(0);                                                               //取到一级目录中的第一个category
        Integer id = categoryFirst.getId();                                                                         //取到第一个category的id
        Category currentCatalog = categoryMapper.queryCurrentCatalog(id);                                           //取到第一个category
        List<Category> currentSubCategory = categoryMapper.queryCurrentSubCategory(id);                             //取到第一个category的二级category
        Catalog catalogIndex = new Catalog();
        catalogIndex.setCategoryList(categoryList);
        catalogIndex.setCurrentCategory(currentCatalog);
        catalogIndex.setCurrentSubCategory(currentSubCategory);
        return catalogIndex;
    }

    @Override
    public Catalog queryCurrentCatalog(int id) {
        Catalog catalogCurrent = new Catalog();
        Category currentCatalog = categoryMapper.queryCurrentCatalog(id);
        List<Category> currentSubCategory = categoryMapper.queryCurrentSubCategory(id);
        catalogCurrent.setCurrentCategory(currentCatalog);
        catalogCurrent.setCurrentSubCategory(currentSubCategory);
        return catalogCurrent;
    }


}
