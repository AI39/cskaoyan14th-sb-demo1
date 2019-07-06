package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Category;
import com.cskaoyan14th.bean.CategoryForGoods;
import com.cskaoyan14th.mapper.CategoryMapper;
import com.cskaoyan14th.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
