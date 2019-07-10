package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Permission;
import com.cskaoyan14th.mapper.PermissionMapper;
import com.cskaoyan14th.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> queryAdminByPrincipal(int[] roleIds) {

        List<Permission> permissionList = permissionMapper.queryAdminByPrincipal(roleIds);
        return  permissionList;
    }

    @Override
    public String[] queryPermissionByRoleids(int[] admin) {

        String[] logInfo = permissionMapper.queryPermissionByRoleids(admin);

        return logInfo;
    }
}
