package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Role;
import com.cskaoyan14th.mapper.RoleMapper;
import com.cskaoyan14th.service.RoleService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public ResponseVo queryRoleAll() {
        ResponseVo<List<Role>> roleResponseVo = new ResponseVo<>();

        List<Role> roleList = roleMapper.queryRoleAll();

        if( roleList != null){
            roleResponseVo.setErrno(0);
            roleResponseVo.setErrmsg("成功");
            roleResponseVo.setData(roleList);
        }
        return roleResponseVo;
    }
}
