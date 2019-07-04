package com.cskaoyan14th.test;

import com.cskaoyan14th.Cskaoyan14thSbDemo1ApplicationTests;
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
}
