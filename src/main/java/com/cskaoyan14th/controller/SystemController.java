package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.System;
import com.cskaoyan14th.bean.SystemFrightMin;
import com.cskaoyan14th.bean.SystemKeyValue;
import com.cskaoyan14th.bean.SystemOrderComment;
import com.cskaoyan14th.mapper.SystemMapper;
import com.cskaoyan14th.vo.Admin2;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SystemController {

    @Autowired
    SystemMapper systemMapper;

    @GetMapping("config/mall")
    @ResponseBody
    public ResponseVo<SystemKeyValue> mall() {
        SystemKeyValue systemKeyValue1 = new SystemKeyValue();

        systemKeyValue1.setCskaoyan_mall_mall_address(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_address"));
        systemKeyValue1.setCskaoyan_mall_mall_name(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_name"));
        systemKeyValue1.setCskaoyan_mall_mall_phone(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_phone"));
        systemKeyValue1.setCskaoyan_mall_mall_qq(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_qq"));

        return new ResponseVo<SystemKeyValue>(0, systemKeyValue1, "成功");

    }

    @PostMapping("config/mall")
    @ResponseBody
    public ResponseVo<SystemKeyValue> mall(@RequestBody SystemKeyValue systemKeyValue) {
        SystemKeyValue systemKeyValue1 = new SystemKeyValue();

        systemMapper.updateSystemKeyValue(systemKeyValue.getCskaoyan_mall_mall_address(), "cskaoyan_mall_mall_address");
        systemMapper.updateSystemKeyValue(systemKeyValue.getCskaoyan_mall_mall_name(), "cskaoyan_mall_mall_name");
        systemMapper.updateSystemKeyValue(systemKeyValue.getCskaoyan_mall_mall_phone(), "cskaoyan_mall_mall_phone");
        systemMapper.updateSystemKeyValue(systemKeyValue.getCskaoyan_mall_mall_qq(), "cskaoyan_mall_mall_qq");

        systemKeyValue1.setCskaoyan_mall_mall_address(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_address"));
        systemKeyValue1.setCskaoyan_mall_mall_name(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_name"));
        systemKeyValue1.setCskaoyan_mall_mall_phone(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_phone"));
        systemKeyValue1.setCskaoyan_mall_mall_qq(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_qq"));

        return new ResponseVo<SystemKeyValue>(0, systemKeyValue1, "成功");

    }

    @GetMapping("config/express")
    @ResponseBody
    public ResponseVo<SystemFrightMin> mall1() {
        SystemFrightMin systemFrightMin1 = new SystemFrightMin();

        systemFrightMin1.setCskaoyan_mall_express_freight_min(systemMapper.querySystemByFrightMin("cskaoyan_mall_express_freight_min"));
        systemFrightMin1.setCskaoyan_mall_express_freight_value(systemMapper.querySystemByFrightMin("cskaoyan_mall_express_freight_value"));

        return new ResponseVo<SystemFrightMin>(0, systemFrightMin1, "成功");

    }

    @PostMapping("config/express")
    @ResponseBody
    public ResponseVo<SystemFrightMin> mall(@RequestBody SystemFrightMin systemFrightMin) {
        SystemFrightMin systemFrightMin1 = new SystemFrightMin();

        systemMapper.updateSystemByFrightMin(systemFrightMin.getCskaoyan_mall_express_freight_min(), "cskaoyan_mall_express_freight_min");
        systemMapper.updateSystemByFrightMin(systemFrightMin.getCskaoyan_mall_express_freight_value(), "cskaoyan_mall_express_freight_value");

        systemFrightMin1.setCskaoyan_mall_express_freight_min(systemMapper.querySystemByFrightMin("cskaoyan_mall_express_freight_min"));
        systemFrightMin1.setCskaoyan_mall_express_freight_value(systemMapper.querySystemByFrightMin("cskaoyan_mall_express_freight_value"));

        return new ResponseVo<SystemFrightMin>(0, systemFrightMin1, "成功");

    }
    @GetMapping("config/order")
    @ResponseBody
    public ResponseVo<SystemOrderComment> mall2() {
        SystemOrderComment systemOrderComment1 = new SystemOrderComment();

        systemOrderComment1.setCskaoyan_mall_order_comment(systemMapper.querySystemByOrder("cskaoyan_mall_order_comment"));
        systemOrderComment1.setCskaoyan_mall_order_unpaid(systemMapper.querySystemByOrder("cskaoyan_mall_order_unpaid"));
        systemOrderComment1.setCskaoyan_mall_order_unconfirm(systemMapper.querySystemByOrder("cskaoyan_mall_order_unconfirm"));
        return new ResponseVo<SystemOrderComment>(0, systemOrderComment1, "成功");
    }
    @PostMapping("config/order")
    @ResponseBody
    public ResponseVo<SystemOrderComment> mall(@RequestBody SystemOrderComment systemOrderComment) {
        SystemOrderComment systemOrderComment1 = new SystemOrderComment();

        systemMapper.updateSystemByOrder(systemOrderComment.getCskaoyan_mall_order_comment(), "cskaoyan_mall_order_comment");
        systemMapper.updateSystemByOrder(systemOrderComment.getCskaoyan_mall_order_unpaid(), "cskaoyan_mall_order_unpaid");
        systemMapper.updateSystemByOrder(systemOrderComment.getCskaoyan_mall_order_unconfirm(),"cskaoyan_mall_order_unconfirm");

        systemOrderComment1.setCskaoyan_mall_order_comment(systemMapper.querySystemByOrder("cskaoyan_mall_order_comment"));
        systemOrderComment1.setCskaoyan_mall_order_unpaid(systemMapper.querySystemByOrder("cskaoyan_mall_order_unpaid"));
        systemOrderComment1.setCskaoyan_mall_order_unconfirm(systemMapper.querySystemByOrder("cskaoyan_mall_order_unconfirm"));

        return new ResponseVo<SystemOrderComment>(0, systemOrderComment1 , "成功");
    }

}