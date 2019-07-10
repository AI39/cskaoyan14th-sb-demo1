package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Role;

import java.util.List;

import com.cskaoyan14th.bean.shiro.AuthorDataOne;
import com.cskaoyan14th.bean.shiro.AuthorDataTwo;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

    List<Role> queryRoleAll();

    List<Role> queryRoleByName(@Param("name") String name);

    int insertRole(@Param("role") Role role);

    Role queryRoleByNa(@Param("role")Role role);

    int updateRoleById(@Param("role")Role role);

    int deleteRoleById(@Param("role")Role role);

    String[] queryNameByRoleids(@Param("adm") int[] admin);

    List<String> queryNameByRoleid(@Param("role") int roleId);


    List<String> queryCategoryRoles();

    AuthorDataOne queryCategoryAll(@Param("i")int i);

    List<AuthorDataTwo> selectPermission(@Param("i")int i);
}