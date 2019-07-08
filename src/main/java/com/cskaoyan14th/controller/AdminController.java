package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.service.AdminService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo list(int page, int limit, String username){
        ResponseVo responseVo = adminService.queryAdminAll(page,limit,username);
        return responseVo;
    }

    @RequestMapping("create")
    @ResponseBody
    public ResponseVo<Admin> create(@RequestBody Admin admin){
        int i = adminService.insertAdmin(admin);
        ResponseVo<Admin> adminResponseVo = adminService.queryAdminByUsername(admin);

        return  adminResponseVo;
    }

    @RequestMapping("update")
    @ResponseBody
    public ResponseVo<Admin> update(@RequestBody Admin admin){
        int i = adminService.updateAdmin(admin);
        ResponseVo<Admin> adminResponseVo = adminService.queryAdminById(admin);
        return adminResponseVo;
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseVo delete(@RequestBody Admin admin){
        ResponseVo responseVo = adminService.deleteAdmin(admin);
        return responseVo;
    }
}
