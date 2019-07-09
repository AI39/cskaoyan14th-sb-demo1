package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Role;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;

public interface RoleService {

    ResponseVo queryRoleAll();

    ResponseVo<Page<Role>> queryRoleByName(int page, int limit, String name);

    ResponseVo<Role> queryRoleByNa(Role role);

    int insertRole(Role role);

    ResponseVo updateRoleById(Role role);

    ResponseVo deleteById(Role role);

    String[] queryNameByRoleids(int[] admin);
}
