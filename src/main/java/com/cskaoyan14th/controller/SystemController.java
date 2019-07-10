package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.bean.System;
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
    /*商场配置*/

    @GetMapping("admin/config/mall")
    @ResponseBody
    public ResponseVo<SystemKeyValue> mall() {

        SystemKeyValue systemKeyValue1 = new SystemKeyValue();

        systemKeyValue1.setCskaoyan_mall_mall_address(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_address"));

        systemKeyValue1.setCskaoyan_mall_mall_name(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_name"));

        systemKeyValue1.setCskaoyan_mall_mall_phone(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_phone"));

        systemKeyValue1.setCskaoyan_mall_mall_qq(systemMapper.querySystemByKeyValue("cskaoyan_mall_mall_qq"));

        return new ResponseVo<SystemKeyValue>(0, systemKeyValue1, "成功");

    }
    /*商场配置*/

    @PostMapping("admin/config/mall")
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

    /*运费配置*/
    @GetMapping("admin/config/express")
    @ResponseBody
    public ResponseVo<SystemFrightMin> mall1() {

        SystemFrightMin systemFrightMin1 = new SystemFrightMin();

        systemFrightMin1.setCskaoyan_mall_express_freight_min(systemMapper.querySystemByFrightMin("cskaoyan_mall_express_freight_min"));
        systemFrightMin1.setCskaoyan_mall_express_freight_value(systemMapper.querySystemByFrightMin("cskaoyan_mall_express_freight_value"));

        return new ResponseVo<SystemFrightMin>(0, systemFrightMin1, "成功");

    }
    /*运费配置*/

    @PostMapping("admin/config/express")
    @ResponseBody
    public ResponseVo<SystemFrightMin> mall(@RequestBody SystemFrightMin systemFrightMin) {

        SystemFrightMin systemFrightMin1 = new SystemFrightMin();

        systemMapper.updateSystemByFrightMin(systemFrightMin.getCskaoyan_mall_express_freight_min(), "cskaoyan_mall_express_freight_min");
        systemMapper.updateSystemByFrightMin(systemFrightMin.getCskaoyan_mall_express_freight_value(), "cskaoyan_mall_express_freight_value");

        systemFrightMin1.setCskaoyan_mall_express_freight_min(systemMapper.querySystemByFrightMin("cskaoyan_mall_express_freight_min"));
        systemFrightMin1.setCskaoyan_mall_express_freight_value(systemMapper.querySystemByFrightMin("cskaoyan_mall_express_freight_value"));

        return new ResponseVo<SystemFrightMin>(0, systemFrightMin1, "成功");

    }

    /*订单配置*/

    @GetMapping("admin/config/order")
    @ResponseBody
    public ResponseVo<SystemOrderComment> mall2() {

        SystemOrderComment systemOrderComment1 = new SystemOrderComment();

        systemOrderComment1.setCskaoyan_mall_order_comment(systemMapper.querySystemByOrder("cskaoyan_mall_order_comment"));
        systemOrderComment1.setCskaoyan_mall_order_unpaid(systemMapper.querySystemByOrder("cskaoyan_mall_order_unpaid"));

        systemOrderComment1.setCskaoyan_mall_order_unconfirm(systemMapper.querySystemByOrder("cskaoyan_mall_order_unconfirm"));

        return new ResponseVo<SystemOrderComment>(0, systemOrderComment1, "成功");
    }

    /*订单配置*/
    @PostMapping("admin/config/order")
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

    /*小程序配置*/
    @GetMapping("admin/config/wx")
    @ResponseBody
    public ResponseVo<SystemWx> mall3() {

        SystemWx systemWx1 = new SystemWx();

        systemWx1.setCskaoyan_mall_wx_share(systemMapper.querySystemByWx("cskaoyan_mall_wx_share"));
        systemWx1.setCskaoyan_mall_wx_catlog_goods(systemMapper.querySystemByWx("cskaoyan_mall_wx_catlog_goods"));
        systemWx1.setCskaoyan_mall_wx_catlog_list(systemMapper.querySystemByWx("cskaoyan_mall_wx_catlog_list"));
        systemWx1.setCskaoyan_mall_wx_index_brand(systemMapper.querySystemByWx("cskaoyan_mall_wx_index_brand"));
        systemWx1.setCskaoyan_mall_wx_index_hot(systemMapper.querySystemByWx("cskaoyan_mall_wx_index_hot"));
        systemWx1.setCskaoyan_mall_wx_index_topic(systemMapper.querySystemByWx("cskaoyan_mall_wx_index_topic"));
        systemWx1.setCskaoyan_mall_wx_index_new(systemMapper.querySystemByWx("cskaoyan_mall_wx_index_new"));

       return new ResponseVo<SystemWx>(0, systemWx1, "成功");
    }

    /*小程序配置*/
    @PostMapping("admin/config/wx")
    @ResponseBody
    public ResponseVo<SystemWx> mall(@RequestBody SystemWx systemWx) {

        SystemWx systemWx1 = new SystemWx();

        systemMapper.updateSystemByWx(systemWx.getCskaoyan_mall_wx_share(),"cskaoyan_mall_wx_share");
        systemMapper.updateSystemByWx(systemWx.getCskaoyan_mall_wx_catlog_goods(),"cskaoyan_mall_wx_catlog_goods");
        systemMapper.updateSystemByWx(systemWx.getCskaoyan_mall_wx_catlog_list(),"cskaoyan_mall_wx_catlog_list");
        systemMapper.updateSystemByWx(systemWx.getCskaoyan_mall_wx_index_brand(),"cskaoyan_mall_wx_index_brand");
        systemMapper.updateSystemByWx(systemWx.getCskaoyan_mall_wx_index_hot(),"cskaoyan_mall_wx_index_hot");
        systemMapper.updateSystemByWx(systemWx.getCskaoyan_mall_wx_index_topic(),"cskaoyan_mall_wx_index_topic");
        systemMapper.updateSystemByWx(systemWx.getCskaoyan_mall_wx_index_new(),"cskaoyan_mall_wx_index_new");

        systemWx1.setCskaoyan_mall_wx_share(systemMapper.querySystemByWx("cskaoyan_mall_wx_share"));
        systemWx1.setCskaoyan_mall_wx_catlog_goods(systemMapper.querySystemByWx("cskaoyan_mall_wx_catlog_goods"));
        systemWx1.setCskaoyan_mall_wx_catlog_list(systemMapper.querySystemByWx("cskaoyan_mall_wx_catlog_list"));
        systemWx1.setCskaoyan_mall_wx_index_brand(systemMapper.querySystemByWx("cskaoyan_mall_wx_index_brand"));
        systemWx1.setCskaoyan_mall_wx_index_hot(systemMapper.querySystemByWx("cskaoyan_mall_wx_index_hot"));
        systemWx1.setCskaoyan_mall_wx_index_topic(systemMapper.querySystemByWx("cskaoyan_mall_wx_index_topic"));
        systemWx1.setCskaoyan_mall_wx_index_new(systemMapper.querySystemByWx("cskaoyan_mall_wx_index_new"));

        return new ResponseVo<SystemWx>(0, systemWx1 , "成功");
    }

}