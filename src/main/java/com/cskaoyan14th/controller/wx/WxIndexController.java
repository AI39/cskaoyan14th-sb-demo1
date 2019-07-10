package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.*;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.wrapper.FloorGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("wx/home")
@RestController
public class WxIndexController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    AdService adService;

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SystemService systemService;

    @RequestMapping("index")
    public ResponseVo<Map<String, Object>> index() {

        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        HashMap<String, Object> map = new HashMap<>();

        //获取newGoodsList
        String cskaoyan_mall_wx_index_new = systemService.querySystemByWx("cskaoyan_mall_wx_index_new");
        int newGoodsCount = Integer.parseInt(cskaoyan_mall_wx_index_new);

        List<Goods> newGoodsList = goodsService.getNewGoodsList(newGoodsCount);
        map.put("newGoodsList", newGoodsList);

        //获取couponList
        List<Coupon> couponList = adService.getCouponAll();
        map.put("couponList", couponList);

        //获取channel
        WxCatalog wxCatalogIndex = categoryService.queryCatalogIndex();
        List<Category> channel = wxCatalogIndex.getCategoryList();
        map.put("channel", channel);
        //获取grouponList
        List<Grouponx> grouponList = adService.selectGrouponxLimit();
        map.put("grouponList", grouponList);
        //获取banner
        List<Ad> banner = adService.getAdAll();
        map.put("banner", banner);
        //获取brandList
        String cskaoyan_mall_wx_index_brand = systemService.querySystemByWx("cskaoyan_mall_wx_index_brand");

        int brandCount = Integer.parseInt(cskaoyan_mall_wx_index_brand);
        List<Brand> brandList = brandService.queryWxBrandList(1, brandCount);
        map.put("brandList", brandList);
        //获取hotGoodsList
        String cskaoyan_mall_wx_index_hot = systemService.querySystemByWx("cskaoyan_mall_wx_index_hot");

        int hotGoodsCount = Integer.parseInt(cskaoyan_mall_wx_index_hot);
        List<Goods> hotGoodsList = goodsService.getHotGoodsList(hotGoodsCount);
        map.put("hotGoodsList", hotGoodsList);
        //获取topicList
        List<Topic> topicList = adService.getTopicAll();
        map.put("topicList", topicList);
        //获取floorGoodsList
        String cskaoyan_mall_wx_catlog_list = systemService.querySystemByWx("cskaoyan_mall_wx_catlog_list");
        String cskaoyan_mall_wx_catlog_goods = systemService.querySystemByWx("cskaoyan_mall_wx_catlog_goods");

        int catlogCount = Integer.parseInt(cskaoyan_mall_wx_catlog_list);
        int catlogGoodsCount = Integer.parseInt(cskaoyan_mall_wx_catlog_goods);

        List<FloorGoods> floorGoodsList = goodsService.getFloorGoodsList(catlogCount, catlogGoodsCount);
        map.put("floorGoodsList", floorGoodsList);



        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(map);

        return responseVo;
    }
}
