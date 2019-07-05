package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.wrapper.GoodsParam;

import java.util.List;

public interface GoodsService {
    Page<Goods> getGoodsPage(int page, int limit, String sort, String order);

    List<CategoryForGoods> getCategoryForGoods();

    List<CatAndBrandChildren> getBrandForGoods();

    Boolean goodsNameIsExist(String name);

    Boolean insertGoods4(GoodsParam goodsParam);

    GoodsParam getGoodsParam(int id);

    Boolean updateGoods4(GoodsParam goodsParam);

    Boolean deleteGoods4(Goods goods);
}
