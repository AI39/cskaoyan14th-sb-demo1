package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Goods;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.ResponseMapVo;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.wrapper.GoodsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/goods")
public class WxGoodsController {
    @Autowired
    GoodsService goodsService;

    //显示商品总数量
    @RequestMapping("count")
    public ResponseMapVo count() {
        ResponseMapVo responseMapVo = new ResponseMapVo();
        HashMap<String, Object> data = new HashMap<>();

        int count = goodsService.getGoodsCount();
        data.put("goodsCount", 239);
        responseMapVo.setErrno(0);
        responseMapVo.setErrmsg("成功");
        responseMapVo.setData(data);
        return responseMapVo;
    }

    //商品搜索
    @RequestMapping("list")
    public ResponseMapVo list(String keyword, int page, int size, String sort, String order, int categoryId) {
        ResponseMapVo responseMapVo = new ResponseMapVo();
        Map<String, Object> data = new HashMap<>();
        List<Goods> goodsList = goodsService.getGoodsListByPage(keyword, page, size, sort, order, categoryId);
        data.put("goodsList", goodsList);
        responseMapVo.setData(data);
        responseMapVo.setErrmsg("成功");
        responseMapVo.setErrno(0);
        return responseMapVo;
    }

    //商品详情
    @RequestMapping("detail")
    public ResponseVo<GoodsDetail> detail(int id) {
        ResponseVo<GoodsDetail> responseVo = new ResponseVo();
        GoodsDetail goodsDetail = goodsService.getGoodsDetailByGoodsId(id);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(goodsDetail);
        return responseVo;
    }

    //相关商品
    @RequestMapping("related")
    public ResponseMapVo related(int id) {
        ResponseMapVo responseMapVo = new ResponseMapVo();
        HashMap<String, Object> map = new HashMap<>();
        List<Goods> goodsList = goodsService.getRelatedGoods(id);
        responseMapVo.setErrno(0);
        responseMapVo.setErrmsg("成功");
        map.put("goodsList", goodsList);

        responseMapVo.setData(map);
        return responseMapVo;
    }
}
