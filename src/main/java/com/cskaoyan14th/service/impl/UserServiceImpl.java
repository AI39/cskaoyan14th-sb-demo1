package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.OrderExample;
import com.cskaoyan14th.bean.User;
import com.cskaoyan14th.bean.UserExample;
import com.cskaoyan14th.mapper.OrderMapper;
import com.cskaoyan14th.mapper.UserMapper;
import com.cskaoyan14th.service.UserService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired(required = false)
    OrderMapper orderMapper;

    @Override
    public Page<User> getPageList(int page, int limit) {
        PageHelper.startPage(page,limit);

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<User> users = userMapper.selectByExample(example);

        PageInfo<User> pageInfo = new PageInfo<>(users);

        Page<User> userList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());

        return userList;
    }

    @Override
    public Page<User> getPageList(int page, int limit, String sort, String order) {

        PageHelper.startPage(page,limit);
        List<User> users = userMapper.selectUserListOrder(sort, order);

        PageInfo<User> pageInfo = new PageInfo<>(users);
        Page<User> userList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());

        return userList;
    }

    @Override
    public Page<User> getPageList(int page, int limit, String username, String mobile, String sort, String order) {

        PageHelper.startPage(page,limit);
        List<User> users = userMapper.selectUserListOrder(username,mobile,sort, order);

        PageInfo<User> pageInfo = new PageInfo<>(users);
        Page<User> userList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());

        return userList;
    }

    @Override
    public User getUser(String username, String password) {
        return userMapper.selectUserByUsernameAndPassword(username, password);
    }

    @Override
    public long countByOrderStatus(short orderStat) {

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderStatusEqualTo(orderStat);

        return orderMapper.countByExample(orderExample);
    }
}
