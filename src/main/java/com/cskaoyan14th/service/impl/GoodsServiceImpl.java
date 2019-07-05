package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.GoodsMapper;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Page<Goods> getGoodsPage(int page, int limit, String sort, String order) {
        PageHelper.startPage(page, limit);

        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sort + " " + order);
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);

        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        Page<Goods> goodsPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        return goodsPage;
    }

    @Override
    public List<CategoryForGoods> getCategoryForGoods() {
        return goodsMapper.selectCategoryForGoods();
    }

    @Override
    public List<CatAndBrandChildren> getBrandForGoods() {
        return goodsMapper.selectBrandsForGoods();
    }

    @Override
    public Boolean goodsNameIsExist(String name) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        if(goodsList != null && goodsList.size() != 0) {
            return true;
        }
        return false;
    }


}
