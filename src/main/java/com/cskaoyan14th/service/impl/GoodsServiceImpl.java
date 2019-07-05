package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.GoodsAttributeMapper;
import com.cskaoyan14th.mapper.GoodsMapper;
import com.cskaoyan14th.mapper.GoodsProductMapper;
import com.cskaoyan14th.mapper.GoodsSpecificationMapper;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;
    @Autowired
    GoodsSpecificationMapper goodsSpecificationMapper;

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

    @Override
    @Transactional
    public Boolean insertGoods4(Goods goods, GoodsSpecification[] specifications, GoodsProduct[] products, GoodsAttribute[] attributes) {
        Date date = new Date();

        try {
            // 插入goods并获取id
            goods.setAddTime(date);
            goods.setUpdateTime(date);
            goodsMapper.insertSelective(goods);
            int id = goods.getId();

            //封装goodsId插入数据库
            for (GoodsSpecification goodsSpecification : specifications) {
                goodsSpecification.setAddTime(date);
                goodsSpecification.setUpdateTime(date);
                goodsSpecification.setGoodsId(id);
                goodsSpecificationMapper.insertSelective(goodsSpecification);
            }

            for (GoodsProduct goodsProduct : products) {
                goodsProduct.setAddTime(date);
                goodsProduct.setUpdateTime(date);
                //goodsProduct.setId(null);
                goodsProduct.setGoodsId(id);
                goodsProductMapper.insertSelective(goodsProduct);
            }

            for (GoodsAttribute goodsAttribute : attributes) {
                goodsAttribute.setAddTime(date);
                goodsAttribute.setUpdateTime(date);
                goodsAttribute.setGoodsId(id);
                goodsAttributeMapper.insertSelective(goodsAttribute);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }


}
