package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.mapper.AdminMapper;
import com.cskaoyan14th.service.AdminService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public ResponseVo queryAdminAll(int page, int limit) {
        ResponseVo<Page<Admin>> adminResponseVo = new ResponseVo<>();

        PageHelper.startPage(page,limit);
        //查询
        List<Admin> adminList = adminMapper.queryAdminAll();

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
}
