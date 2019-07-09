package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.bean.LogInfo;
import com.cskaoyan14th.bean.Permission;
import com.cskaoyan14th.bean.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {

    List<Permission> queryAdminByPrincipal(@Param("roleids") int[] roleIds);

    String[] queryPermissionByRoleids(@Param("adm") int[] admin);
}