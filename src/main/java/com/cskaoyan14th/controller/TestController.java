package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.mapper.AdminMapper;
import com.cskaoyan14th.vo.Admin2;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class TestController {

    @Autowired
    AdminMapper adminMapper;


    @RequestMapping("admin/auth/login")
    @ResponseBody
    public ResponseVo login() {
        return new ResponseVo(0, UUID.randomUUID().toString(), "成功");
    }

    @RequestMapping("admin/auth/info")
    @ResponseBody
    public ResponseVo<Admin2> info(String token) {
        Admin2 admin2 = new Admin2("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif", "admin123", new String[]{"*"}, new String[]{"超级管理员"});
        return new ResponseVo<Admin2>(0, admin2, "成功");
    }

<<<<<<< HEAD
    @RequestMapping("admin/auth/testSql")
=======

    @RequestMapping("auth/testSql")
>>>>>>> 48d5bd0012c9eeca030f2ef2f3d6d35b3e893f91
    @ResponseBody
    public Admin testSql() {
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
        return admin;
    }




}
