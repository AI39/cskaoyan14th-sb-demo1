package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Role;
import com.cskaoyan14th.bean.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

    List<Role> queryRoleAll();
}