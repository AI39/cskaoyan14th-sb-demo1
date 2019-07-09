package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> queryAdminByPrincipal(int[] roleIds);

    String[] queryPermissionByRoleids(int[] admin);
}
