package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.bean.Role;
import com.cskaoyan14th.bean.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

    List<Role> queryRoleAll();

    List<Role> queryRoleByName(@Param("name") String name);

    int insertRole(@Param("role") Role role);

    Role queryRoleByNa(@Param("role")Role role);

    int updateRoleById(@Param("role")Role role);

    int deleteRoleById(@Param("role")Role role);

    String[] queryNameByRoleids(@Param("adm") int[] admin);
}