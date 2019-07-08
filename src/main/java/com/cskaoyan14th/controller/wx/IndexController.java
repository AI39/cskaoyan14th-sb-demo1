package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Goods;
import com.cskaoyan14th.service.AdService;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("wx/home")
@RestController
public class IndexController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    AdService adService;


    @RequestMapping("index")
    public ResponseVo<Map<String, Object>> index() {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        HashMap<String, Object> map = new HashMap<>();

        //获取newGoodsList
        List<Goods> newGoodsList = goodsService.getNewGoodsList();
        map.put("newGoodsList", newGoodsList);
        //获取couponList
        map.put("couponList", null);
        //获取grouponList
        map.put("grouponList", null);
        //获取brandList
        map.put("brandList", null);
        //获取topicList
        map.put("topicList", null);
        //获取floorGoodsList
        map.put("floorGoodsList", null);

        //获取hotGoodsList
        map.put("hotGoodsList", null);

        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(map);
        return responseVo;
    }
}
