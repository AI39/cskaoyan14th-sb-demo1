package com.cskaoyan14th.test;

import com.cskaoyan14th.Cskaoyan14thSbDemo1ApplicationTests;
import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.CommentMapper;
import com.cskaoyan14th.mapper.GoodsMapper;
import com.cskaoyan14th.mapper.GoodsProductMapper;
import com.cskaoyan14th.mapper.GoodsSpecificationMapper;
import com.cskaoyan14th.wrapper.FloorGoods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.System;
import java.util.List;

public class GoodsTest extends Cskaoyan14thSbDemo1ApplicationTests {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Autowired
    GoodsSpecificationMapper goodsSpecificationMapper;

    @Autowired
    CommentMapper commentMapper;

    @Test
    public void test1() {
        GoodsExample goodsExample = new GoodsExample();
        //goodsExample.setOrderByClause("add_time" + " " + "desc");
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        System.out.println(goodsList);

    }

    @Test
    public void test2() {
        List<CategoryForGoods> categoryForGoods = goodsMapper.selectCategoryForGoods();
        System.out.println(categoryForGoods);

    }

    @Test
    public void test3() {
        List<CatAndBrandChildren> catAndBrandChildren = goodsMapper.selectBrandsForGoods();
        System.out.println(catAndBrandChildren);

    }

    @Test
    public void test4() {
        GoodsSpecification goodsSpecification = goodsSpecificationMapper.selectByPrimaryKey(1);
        System.out.println(goodsSpecification);
    }

    @Test
    public void test5() {
        GoodsSpecification goodsSpecification = new GoodsSpecification();
        goodsSpecification.setGoodsId(111111111);
        int i = goodsSpecificationMapper.insertSelective(goodsSpecification);
        System.out.println(i);
    }

    @Test
    public void test6() {
        Goods goods = new Goods();
        goods.setGoodsSn("1234567890");
        goods.setName("1234567");
        int i = goodsMapper.insert(goods);
        System.out.println(goods.getId());
    }

    @Test
    public void test7() {
        GoodsProduct goodsProduct = new GoodsProduct();
        goodsProduct.setNumber(1);
        int i = goodsProductMapper.insertSelective(goodsProduct);
        System.out.println(i);
    }

    @Test
    public void test8() {
        Comment comment = commentMapper.selectByPrimaryKey(1);
        System.out.println(comment);
    }


    @Test
    public void test9() {
        List<Goods> goodsList = goodsMapper.selectLimitByParentCategoryId(1005000, 3);
        System.out.println(goodsList);
    }
}
