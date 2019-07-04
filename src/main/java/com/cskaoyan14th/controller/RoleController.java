package com.cskaoyan14th.controller;

import com.cskaoyan14th.service.RoleService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("options")
    @ResponseBody
    public ResponseVo roleOptions(){
        ResponseVo responseVo = roleService .queryRoleAll();
        return responseVo;
    }
}
