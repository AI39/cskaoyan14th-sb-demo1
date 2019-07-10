package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Role;
import com.cskaoyan14th.bean.shiro.AuthorDataOne;
import com.cskaoyan14th.bean.shiro.AuthorDataTwo;
import com.cskaoyan14th.mapper.RoleMapper;
import com.cskaoyan14th.service.RoleService;
import com.cskaoyan14th.vo.DateCurrentTime;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public ResponseVo queryRoleAll() {
        ResponseVo<List<Role>> roleResponseVo = new ResponseVo<>();

        List<Role> roleList = roleMapper.queryRoleAll();

        if( roleList != null){
            roleResponseVo.setErrno(0);
            roleResponseVo.setErrmsg("成功");
            roleResponseVo.setData(roleList);
        }
        return roleResponseVo;
    }

    @Override
    public ResponseVo<Page<Role>> queryRoleByName(int page, int limit, String name) {

        ResponseVo<Page<Role>> adminResponseVo = new ResponseVo<>();

        PageHelper.startPage(page,limit);
        //查询
        List<Role> roleList = roleMapper.queryRoleByName(name);

        PageInfo pageInfo = new PageInfo(roleList);

        Page<Role> adminPage = new Page<Role>(pageInfo.getList(), pageInfo.getTotal());
        //判断 是否为空
        if(roleList != null){
            adminResponseVo.setErrno(0);
            adminResponseVo.setErrmsg("成功");
            adminResponseVo.setData(adminPage);
        }

        return adminResponseVo;
    }

    @Override
    public ResponseVo<Role> queryRoleByNa(Role role) {

        ResponseVo<Role> roleResponseVo= new ResponseVo<>();
        Role role1 = roleMapper.queryRoleByNa(role);

        if(role1 != null){
            roleResponseVo.setErrno(0);
            roleResponseVo.setErrmsg("成功");
            roleResponseVo.setData(role1);
        }
        return roleResponseVo;
    }

    @Override
    public int  insertRole(Role role) {

        Date date = DateCurrentTime.dateCurrentTime();
        System.out.println(date);
        role.setAddTime(date);
        role.setUpdateTime(date);

        int i = roleMapper.insertRole(role);
        return i;
    }

    @Override
    public ResponseVo updateRoleById(Role role) {

        ResponseVo<Role> roleResponseVo= new ResponseVo<>();

        int i = roleMapper.updateRoleById(role);

        if (i>0){
            roleResponseVo.setErrno(0);
            roleResponseVo.setErrmsg("成功");
        }
        return roleResponseVo;
    }

    @Override
    public ResponseVo deleteById(Role role) {

        ResponseVo<Role> roleResponseVo= new ResponseVo<>();

        int i = roleMapper.deleteRoleById(role);

        if (i>0){
            roleResponseVo.setErrno(0);
            roleResponseVo.setErrmsg("成功");
        }

        return roleResponseVo;
    }

    @Override
    public String[] queryNameByRoleids(int[] admin) {

        String[] strings = roleMapper.queryNameByRoleids(admin);

        return strings;
    }

    @Override
    public ResponseVo<AuthorDataOne> permissions(String roleId) {
        List<String> stringList =roleMapper.queryCategoryRoles();
        List<String> s1 = new ArrayList<>();
        for (String s : stringList) {
            if (s != null ){
                s1.add(s);
            }
        }
        AuthorDataOne authorDataOne1 = new AuthorDataOne();
        authorDataOne1.setAssignedPermissions(s1);
        ResponseVo<AuthorDataOne> authorDataOneResponseVo = new ResponseVo<>();
        List<AuthorDataTwo> authorDataOne = roleMapper.selectPermission(1);
        System.out.println( authorDataOne);
        authorDataOne1.setSystemPermissions(authorDataOne);
        if( authorDataOne1 != null){
            authorDataOneResponseVo.setErrno(0);
            authorDataOneResponseVo.setErrmsg("成功");
            authorDataOneResponseVo.setData(authorDataOne1);
        }
        return authorDataOneResponseVo;
    }
}
