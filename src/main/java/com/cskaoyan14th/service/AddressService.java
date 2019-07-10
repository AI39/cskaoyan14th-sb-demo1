package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.vo.Page;

import java.util.List;

public interface AddressService {
    Page<Address> getPageList(int page, int limit, String sort, String order);

    Page<Address> getPageList(int page, int limit, String name, String userId, String sort, String order);


    //以下是前台用的
    List<Address> getAddressList(int uid);

    int deleteAddressById(int id);
    int deleteAddressById(String id);

    Address getDefaultAddress(Integer uid);

    Address getCheckedAddress(int addressId);

    Address getAddressById(Integer addressId);

    int updateAddress(Address address);
}
