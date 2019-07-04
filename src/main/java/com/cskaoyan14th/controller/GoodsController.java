package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseMapVo;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    //一、商品列表
    //（一）商品列表展示
    @GetMapping("list")
    public ResponseVo<Page<Goods>> list(int page, int limit, String sort, String order) {
        Page<Goods> goodsPage = goodsService.getGoodsPage(page, limit, sort, order);
        ResponseVo<Page<Goods>> responseVo = new ResponseVo<>(0, goodsPage, "成功");
        return responseVo;
    }

    //二、商品上架
    //（一）商品上架category和brand展示
    @GetMapping("catAndBrand")
    public ResponseMapVo catAndBrand() {
        ResponseMapVo responseMapVo = new ResponseMapVo();
        List<CategoryForGoods> categoryList = goodsService.getCategoryForGoods();
        List<CatAndBrandChildren> brandList = goodsService.getBrandForGoods();

        Map<String, Object> data = new HashMap<>();
        data.put("categoryList", categoryList);
        data.put("brandList", brandList);

        responseMapVo.setData(data);
        responseMapVo.setErrmsg("成功");
        responseMapVo.setErrno(0);
        return responseMapVo;
    }
    //(二)商品上架
    @PostMapping("create")
    public ResponseVo<Goods> create(@RequestBody GoodsParam goodsParam)  {
        ResponseVo<Goods> responseVo = new ResponseVo<>();
        Goods goods = goodsParam.getGoods();
        //查看商品名是否已存在
        Boolean flag = goodsService.goodsNameIsExist(goods.getName());
        if(flag) {
            responseVo.setErrmsg("商品名已经存在");
            responseVo.setErrno(611);
            return responseVo;
        }
        //插入goods
        //插入attributes
        //插入products
        //插入specifications
        return null;
    }
}
