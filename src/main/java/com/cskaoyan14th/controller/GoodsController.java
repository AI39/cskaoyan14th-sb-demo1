package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Goods;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping("list")
    public ResponseVo<Page<Goods>> list(int page, int limit, String sort, String order) {
        Page<Goods> goodsPage = goodsService.getGoodsPage(page, limit, sort, order);
        ResponseVo<Page<Goods>> responseVo = new ResponseVo<>(0, goodsPage, "成功");
        return responseVo;
    }
}
