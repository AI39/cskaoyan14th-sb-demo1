package com.cskaoyan14th.test;

import com.cskaoyan14th.Cskaoyan14thSbDemo1ApplicationTests;
import com.cskaoyan14th.bean.CatAndBrandChildren;
import com.cskaoyan14th.bean.CategoryForGoods;
import com.cskaoyan14th.bean.Goods;
import com.cskaoyan14th.bean.GoodsExample;
import com.cskaoyan14th.mapper.GoodsMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsTest extends Cskaoyan14thSbDemo1ApplicationTests {

    @Autowired
    GoodsMapper goodsMapper;

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
}
