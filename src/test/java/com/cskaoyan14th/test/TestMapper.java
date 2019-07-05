package com.cskaoyan14th.test;

import com.cskaoyan14th.Cskaoyan14thSbDemo1ApplicationTests;
import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.bean.AdminExample;
import com.cskaoyan14th.bean.User;
import com.cskaoyan14th.mapper.AdminMapper;
import com.cskaoyan14th.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMapper extends Cskaoyan14thSbDemo1ApplicationTests {

    @Autowired
    AdminMapper mapper;

    @Test
    public void mytest(){
        ResponseVo<List<User>> userResponseVo = new ResponseVo<>();
    }
}
