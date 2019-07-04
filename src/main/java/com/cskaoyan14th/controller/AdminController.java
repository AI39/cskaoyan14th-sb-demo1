package com.cskaoyan14th.controller;

import com.cskaoyan14th.service.AdminService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("list")
    public ResponseVo list(int page,int limit){
        ResponseVo responseVo = adminService.queryAdminAll(page,limit);
        return responseVo;
    }
}
