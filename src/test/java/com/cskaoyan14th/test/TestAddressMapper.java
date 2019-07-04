package com.cskaoyan14th.test;

import com.cskaoyan14th.Cskaoyan14thSbDemo1ApplicationTests;
import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.bean.User;
import com.cskaoyan14th.mapper.AddressMapper;
import com.cskaoyan14th.mapper.UserMapper;
import com.cskaoyan14th.service.AddressService;
import com.cskaoyan14th.service.UserService;
import com.cskaoyan14th.vo.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestAddressMapper extends Cskaoyan14thSbDemo1ApplicationTests {
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    UserMapper userMapper;
    @Test
    public void test1(){
        List<Address> addresses = addressMapper.selectAddressListOrder("先生", "", "add_time", "desc");
        System.out.println(addresses);
    }
    @Test
    public void test2(){
        List<User> users = userMapper.selectUserListOrder("", "", "add_time", "desc");
        System.out.println(users);
    }
    @Autowired
    UserService userService;
    @Test
    public void test3(){
        Page<User> pageList = userService.getPageList(1, 10, "2", "", "add_time", "desc");
        System.out.println(pageList);
    }

    @Autowired
    AddressService addressService;
    @Test
    public void test4(){
        Page<Address> pageList = addressService.getPageList(1, 10, "先生", "", "add_time", "desc");
        System.out.println(pageList);
    }

}
