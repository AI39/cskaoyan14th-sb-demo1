package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.bean.LogInfo;
import com.cskaoyan14th.service.AdminService;
import com.cskaoyan14th.service.LogService;
import com.cskaoyan14th.service.PermissionService;
import com.cskaoyan14th.service.RoleService;
import com.cskaoyan14th.vo.IPAddress;
import com.cskaoyan14th.vo.MD5;
import com.cskaoyan14th.vo.ResponseVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("admin/auth")
@Controller
public class AuthController {
    Map adminMap = new HashMap();
    @Autowired
    AdminService adminService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RoleService roleService;
    @Autowired
    LogService logService;

    @RequestMapping("login")
    @ResponseBody
    public ResponseVo login(@RequestBody Admin admin) {
        //首先获得一个主体，主体就相当于一个用户
        String md5 = MD5.getMd5(admin.getUsername(), admin.getPassword());
        Subject subject = SecurityUtils.getSubject();
        //之后进行认证
        try {
            subject.login(new UsernamePasswordToken(admin.getUsername(), md5));
            String date = (String) subject.getSession().getId();
            adminMap.put(date,admin);
            return new ResponseVo(0,date,"ok");
        } catch (Exception e) {
            return new ResponseVo(500,null,"账号密码错误");
        }
    }
    @RequestMapping("info")
    @ResponseBody
    public ResponseVo info(String token, HttpServletRequest request) {
        String ipAddr = IPAddress.getIpAddr(request);
        Admin admin = (Admin) adminMap.get(token);
        logService.insertLogin(ipAddr,admin.getUsername());
        if (admin != null){
            LogInfo logInfo = new LogInfo();
            logInfo.setAvatar(adminService.queryAdminByUsername(admin).getData().getAvatar());
            logInfo.setName(adminService.queryAdminByUsername(admin).getData().getUsername());
            logInfo.setPerms(permissionService.queryPermissionByRoleids(adminService.queryAdminByUsername(admin).getData().getRoleIds()));
            logInfo.setRoles(roleService.queryNameByRoleids(adminService.queryAdminByUsername(admin).getData().getRoleIds()));
            return new ResponseVo(0,logInfo,"OK");
        }
        return  new ResponseVo(500,null,"admin为 null");
    }

    @RequestMapping("logout")
    @ResponseBody
    public HashMap<String, Object> logout(){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("errno",0);
        stringStringHashMap.put("errmsg","成功");
        return stringStringHashMap;
    }

}
