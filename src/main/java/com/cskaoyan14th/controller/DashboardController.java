package com.cskaoyan14th.controller;

import com.cskaoyan14th.service.impl.DashboardServiceImpl;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DashboardController {
    @Autowired
    DashboardServiceImpl dashboardService;

    @RequestMapping("dashboard")
    @ResponseBody
    public ResponseVo<Map<String, Long>> dashboard() {
        Map<String, Long> map = dashboardService.getTotal();

        return new ResponseVo<>(0, map, "成功");
    }
}
