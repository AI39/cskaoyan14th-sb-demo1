package com.cskaoyan14th.test;

import com.cskaoyan14th.Cskaoyan14thSbDemo1ApplicationTests;
import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.bean.AdminExample;
import com.cskaoyan14th.mapper.AdminMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMapper extends Cskaoyan14thSbDemo1ApplicationTests {

    @Autowired
    AdminMapper mapper;

    @Test
    public void tets1(){
        Admin admin = mapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }



    @Test
    public void testPage(){
        PageHelper.startPage(1,2);

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<Admin> admins = mapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(admins);

        List list = pageInfo.getList();
        System.out.println(list);
    }
}
