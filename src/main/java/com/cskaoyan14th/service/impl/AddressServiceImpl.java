package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.bean.User;
import com.cskaoyan14th.mapper.AddressMapper;
import com.cskaoyan14th.service.AddressService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public Page<Address> getPageList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Address> addresses = addressMapper.selectAddressListOrder(sort, order);
        PageInfo<Address> pageInfo = new PageInfo<>(addresses);
        Page<Address> addressList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        return addressList;
    }

    @Override
    public Page<Address> getPageList(int page, int limit, String name, String userId, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Address> addresses = addressMapper.selectAddressListOrder(name,userId,sort, order);
        PageInfo<Address> pageInfo = new PageInfo<>(addresses);
        Page<Address> addressList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        return addressList;
    }

    @Override
    public List<Address> getAddressList(int uid) {
        //return addressMapper.getListById(uid);
        return addressMapper.getListById();
    }

    @Override
    public int deleteAddressById(int id) {
        return addressMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int deleteAddressById(String id) {
        return addressMapper.deleteByPrimaryKey(Integer.valueOf(id));
    }
}
