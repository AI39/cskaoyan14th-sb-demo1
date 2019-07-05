package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Role;
import com.cskaoyan14th.service.RoleService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Page<Role>> list(int page, int limit,String name){
        ResponseVo<Page<Role>> listResponseVo = roleService.queryRoleByName(page,limit,name);
        return listResponseVo;
    }

    @RequestMapping("create")
    @ResponseBody
    public ResponseVo<Role> create(@RequestBody Role role){
        roleService.insertRole(role);
        ResponseVo<Role> roleResponseVo = roleService.queryRoleByNa(role);
        return roleResponseVo;
    }

    @RequestMapping("update")
    @ResponseBody
    public ResponseVo update(@RequestBody Role role){
        ResponseVo responseVo = roleService.updateRoleById(role);
        return responseVo;
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseVo delete(@RequestBody Role role){
        ResponseVo responseVo = roleService.deleteById(role);
        return responseVo;
    }
}
