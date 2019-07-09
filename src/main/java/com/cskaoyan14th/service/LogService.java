package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Log;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;


public interface LogService {

    ResponseVo<Page<Log>> queryLogAll(int page, int limit, String name);

    int insertLogin(String ipAddr, String username);

    int insertUpdate(String username, String ipAddr);
}
