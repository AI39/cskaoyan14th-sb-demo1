package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.service.AdminService;
import com.cskaoyan14th.service.LogService;
import com.cskaoyan14th.vo.IPAddress;
import com.cskaoyan14th.vo.ResponseVo;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    LogService logService;

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions(value = "*")
    public ResponseVo list(int page, int limit, String username){
        ResponseVo responseVo = adminService.queryAdminAll(page,limit,username);

        return responseVo;
    }

    @RequestMapping("create")
    @ResponseBody
    public ResponseVo<Admin> create(@RequestBody Admin admin){
        int i = adminService.insertAdmin(admin);
        ResponseVo<Admin> adminResponseVo = adminService.queryAdminByUsername(admin);
        System.out.println(adminResponseVo);
        return  adminResponseVo;
    }

    @RequestMapping("update")
    @ResponseBody
    public ResponseVo<Admin> update(@RequestBody Admin admin, HttpServletRequest request){
        String ipAddr = IPAddress.getIpAddr(request);
        logService.insertUpdate(admin.getUsername(),ipAddr);
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
