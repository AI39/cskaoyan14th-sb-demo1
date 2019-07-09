package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.AdService;
import com.cskaoyan14th.service.BrandService;
import com.cskaoyan14th.service.CategoryService;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.Page;
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


    @RequestMapping("index")
    public ResponseVo<Map<String, Object>> index() {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        HashMap<String, Object> map = new HashMap<>();

        //获取newGoodsList
        List<Goods> newGoodsList = goodsService.getNewGoodsList();
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
        List<Brand> brandList = brandService.queryWxBrandList(1, 4);
        map.put("brandList", brandList);
        //获取hotGoodsList
        List<Goods> hotGoodsList = goodsService.getHotGoodsList();
        map.put("hotGoodsList", hotGoodsList);
        //获取topicList
        List<Topic> topicList = adService.getTopicAll();
        map.put("topicList", topicList);
        //获取floorGoodsList
        List<FloorGoods> floorGoodsList = goodsService.getFloorGoodsList();
        map.put("floorGoodsList", floorGoodsList);



        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(map);
        return responseVo;
    }
}
