package com.cskaoyan14th.controller;

import com.cskaoyan14th.service.impl.DashboardServiceImpl;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Total;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashboardController {
    @Autowired
    DashboardServiceImpl dashboardService;

    @RequestMapping("dashboard")
    @ResponseBody
    public ResponseVo<Total> dashboard() {
        Total total = dashboardService.getTotal();
        return new ResponseVo<>(0, total, "成功");
    }
}
