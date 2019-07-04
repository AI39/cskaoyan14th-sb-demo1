package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.vo.Page;

public interface AddressService {
    Page<Address> getPageList(int page, int limit, String sort, String order);

    Page<Address> getPageList(int page, int limit, String name, String userId, String sort, String order);
}
