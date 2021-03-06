package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.wrapper.FloorGoods;
import com.cskaoyan14th.wrapper.GoodsDetail;
import com.cskaoyan14th.wrapper.GoodsParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodsService {

    List<CategoryForGoods> getCategoryForGoods();

    List<CatAndBrandChildren> getBrandForGoods();

    Boolean goodsNameIsExist(String name);

    Boolean insertGoods4(GoodsParam goodsParam);

    GoodsParam getGoodsParam(int id);

    Boolean updateGoods4(GoodsParam goodsParam);

    Boolean deleteGoods4(Goods goods);

    Page<Goods> getGoodsPage(int page, int limit, String goodsSn, String name, String sort, String order);

    List<Goods> getNewGoodsList(int newGoodsCount);

    List<FloorGoods> getFloorGoodsList(int catlogCount, int catlogGoodsCount);

    List<Goods> getHotGoodsList(int hotGoodsCount);

    int getGoodsCount();

    List<Goods> getGoodsListByPage(String keyword, int page, int size, String sort, String order, Integer categoryId, Integer brandId);

    GoodsDetail getGoodsDetailByGoodsId(int id);

    List<Goods> getRelatedGoods(int id);


    Map<String, Object> getCurrentBrotherParentGatogory(int id);

    //在cart/add中使用
    Goods getGoodByGoodsId(Integer goodsId);
    GoodsProduct getProductByProductId(Integer productId);

    int insertSearchHistory(Integer userId, String keyword);

    int insertFootprintByUserIdAndGoodsId(Integer userId, int goodId);

}
