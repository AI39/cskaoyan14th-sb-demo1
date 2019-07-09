package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.bean.Permission;
import com.cskaoyan14th.vo.ResponseVo;

import java.util.List;

public interface AdminService {

    ResponseVo queryAdminAll(int page, int limit, String username);

    int insertAdmin(Admin username);

    ResponseVo<Admin> queryAdminByUsername(Admin username);

    int updateAdmin(Admin admin);

    ResponseVo<Admin> queryAdminById(Admin id);

    ResponseVo deleteAdmin(Admin admin);

    Admin queryPasswordByUsername(String username);

}
