package com.cskaoyan14th.controller;

import com.cskaoyan14th.service.impl.StatServiceImpl;
import com.cskaoyan14th.wrapper.GoodsStat;
import com.cskaoyan14th.wrapper.OrderStat;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.wrapper.UserStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/stat")
public class StatController {

    @Autowired
    StatServiceImpl statService;

    @RequestMapping("user")
    @ResponseBody
    public ResponseVo<Map<String, Object>> user() {

        Map<String, Object> map = new HashMap<>();
        map.put("columns", new String[]{"day", "users"});
        List<UserStat> rows = statService.getUserStatList();
        map.put("rows", rows);

        return new ResponseVo(0, map, "成功");
    }

    @RequestMapping("order")
    @ResponseBody
    public ResponseVo<Map<String, Object>> order() {

        Map<String, Object> map = new HashMap<>();
        map.put("columns", new String[]{"day", "orders", "customers", "amount", "pcr"});

        List<OrderStat> rows = statService.getOrderStatList();
        map.put("rows", rows);

        return new ResponseVo(0, map, "成功");
    }

    @RequestMapping("goods")
    @ResponseBody
    public ResponseVo<Map<String, Object>> goods() {

        Map<String, Object> map = new HashMap<>();
        map.put("columns", new String[]{"day", "orders", "products", "amount"});

        List<GoodsStat> rows = statService.getGoodsStatList();
        map.put("rows", rows);

        return new ResponseVo(0, map, "成功");
    }
}
