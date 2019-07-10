package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Admin;

import com.cskaoyan14th.mapper.AdminMapper;
import com.cskaoyan14th.service.AdminService;
import com.cskaoyan14th.vo.DateCurrentTime;
import com.cskaoyan14th.vo.MD5;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public ResponseVo queryAdminAll(int page, int limit, String username) {

        ResponseVo<Page<Admin>> adminResponseVo = new ResponseVo<>();

        PageHelper.startPage(page,limit);
        //查询
        List<Admin> adminList = adminMapper.queryAdminAll(username);

        PageInfo pageInfo = new PageInfo(adminList);

        Page<Admin> adminPage = new Page<Admin>(pageInfo.getList(), pageInfo.getTotal());
        //判断 是否为空
        if(adminList != null){
            adminResponseVo.setErrno(0);
            adminResponseVo.setErrmsg("成功");
            adminResponseVo.setData(adminPage);
        }

        return adminResponseVo;
    }

    @Override
    public int insertAdmin(Admin admin) {

        Date date = DateCurrentTime.dateCurrentTime();
        System.out.println(date);
        admin.setAddTime(date);
        admin.setUpdateTime(date);

        String md5 = MD5.getMd5(admin.getUsername(), admin.getPassword());
        admin.setPassword(md5);

        int i = adminMapper.insertAdmin(admin);

        return i;
    }

    @Override
    public ResponseVo<Admin> queryAdminByUsername(Admin username) {

        ResponseVo<Admin> adminResponseVo = new ResponseVo<>();

        Admin admin = adminMapper.queryAdminByUsername(username);

        if(admin != null){

            adminResponseVo.setErrno(0);
            adminResponseVo.setErrmsg("成功");
            adminResponseVo.setData(admin);
        }
        return adminResponseVo;
    }

    @Override
    public int updateAdmin(Admin admin) {

        String md5 = MD5.getMd5(admin.getUsername(), admin.getPassword());
        admin.setPassword(md5);

        int i = adminMapper.updatetAdmin(admin);

        return i;
    }

    @Override
    public ResponseVo<Admin> queryAdminById(Admin id) {

        ResponseVo<Admin> adminResponseVo = new ResponseVo<>();

        Admin admin = adminMapper.queryAdminById(id);

        if(admin != null){

            adminResponseVo.setErrno(0);
            adminResponseVo.setErrmsg("成功");
            adminResponseVo.setData(admin);
        }
        return adminResponseVo;
    }

    @Override
    public ResponseVo deleteAdmin(Admin admin) {

        ResponseVo<Admin> adminResponseVo = new ResponseVo<>();

        int i = adminMapper.deleteAdmin(admin);

        if(i > 0){

            adminResponseVo.setErrno(0);
            adminResponseVo.setErrmsg("成功");
        }
        return adminResponseVo;
    }

    @Override
    public Admin queryPasswordByUsername(String username) {

        Admin admin = adminMapper.queryPasswordByUsername(username);

        return  admin;
    }



}
