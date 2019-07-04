package com.cskaoyan14th.service;

import com.cskaoyan14th.vo.ResponseVo;

public interface AdminService {
    ResponseVo queryAdminAll(int page, int limit);
}
