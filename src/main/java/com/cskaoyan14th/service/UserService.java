package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.User;
import com.cskaoyan14th.vo.Page;

public interface UserService {

    Page<User> getPageList(int page,int limit);

    Page<User> getPageList(int page, int limit, String sort, String order);
}
