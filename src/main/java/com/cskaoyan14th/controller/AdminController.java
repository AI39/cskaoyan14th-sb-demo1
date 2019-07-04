package com.cskaoyan14th.controller;

import com.cskaoyan14th.service.AdminService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo list(int page,int limit){
        ResponseVo responseVo = adminService.queryAdminAll(page,limit);
        return responseVo;
    }

}
