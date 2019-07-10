package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseMapVo;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.wrapper.GoodsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    //一、商品列表
    //（一）商品列表展示和模糊查询
    @GetMapping("list")
    public ResponseVo<Page<Goods>> list(int page, int limit, String goodsSn, String name,String sort, String order) {

        Page<Goods> goodsPage = goodsService.getGoodsPage(page, limit, goodsSn, name, sort, order);
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
    //(二)insert
    @PostMapping("create")
    public ResponseVo<Object> create(@RequestBody GoodsParam goodsParam)  {

        ResponseVo<Object> responseVo = new ResponseVo<>();

        //1.获取参数
        Goods goods = goodsParam.getGoods();

        //2.查看商品名是否已存在
        Boolean flag = goodsService.goodsNameIsExist(goods.getName());

        if(flag) {
            responseVo.setErrmsg("商品名已经存在");
            responseVo.setErrno(611);
            return responseVo;
        }
        //3.执行插入操作
        flag = goodsService.insertGoods4(goodsParam);

        if(!flag) {
            responseVo.setErrmsg("系统内部错误");
            responseVo.setErrno(502);
            return responseVo;
        }

        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

    //三、商品编辑

    //(一)商品编辑信息展示
    @RequestMapping("detail")
    public ResponseVo<GoodsParam> detail(int id) {

        ResponseVo<GoodsParam> responseVo = new ResponseVo<>();
        GoodsParam goodsParam = goodsService.getGoodsParam(id);

        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        responseVo.setData(goodsParam);

        return responseVo;
    }

    //(二)update
    @RequestMapping("update")
    public ResponseVo<Object> update(@RequestBody GoodsParam goodsParam) {

        ResponseVo<Object> responseVo = new ResponseVo<>();

        Boolean flag = goodsService.updateGoods4(goodsParam);
        if(!flag) {
            responseVo.setErrmsg("系统内部错误");
            responseVo.setErrno(502);

            return responseVo;
        }

        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

    //四、商品删除
    @RequestMapping("delete")
    public ResponseVo<Object> delete(@RequestBody Goods goods) {

        ResponseVo<Object> responseVo = new ResponseVo<>();

        Boolean flag = goodsService.deleteGoods4(goods);

        if(!flag) {
            responseVo.setErrmsg("系统内部错误");
            responseVo.setErrno(502);
            return responseVo;
        }

        responseVo.setErrmsg("成功");

        responseVo.setErrno(0);
        return responseVo;
    }
}
