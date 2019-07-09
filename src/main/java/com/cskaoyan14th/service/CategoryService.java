package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Category;
import com.cskaoyan14th.bean.CategoryForGoods;
import com.cskaoyan14th.bean.WxCatalog;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:21
 */
public interface CategoryService {

    List<CategoryForGoods> queryCategoryL1();

    List<Category> queryCategoryList();

    int updateCategory(Category category);

    Category createCategory(Category category);

    int deleteCategory(Category category);

    /*微信后台中需要的逻辑*/

    WxCatalog queryCatalogIndex();

    WxCatalog queryCurrentCatalog(int id);
}
