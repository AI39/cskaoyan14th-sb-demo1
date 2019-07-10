package com.cskaoyan14th.shiro;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.bean.Permission;
import com.cskaoyan14th.mapper.AdminMapper;
import com.cskaoyan14th.service.AdminService;
import com.cskaoyan14th.service.PermissionService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component("myrealm")
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    AdminService  adminService;

    @Autowired
    PermissionService permissionService;

    /**
     * 授权 principal
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //principalCollection是SimpleAuthenticationInfo的第一个参数可以使Javabean也可以是String

        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        //先进行校验
        if(principalCollection == null|| StringUtils.isBlank(primaryPrincipal)){
            return null;
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //查询权限信息
        Admin admin = adminService.queryPasswordByUsername(primaryPrincipal);
        List<Permission> permissionList = permissionService.queryAdminByPrincipal(admin.getRoleIds());
        //判空 若不为空则将pojo中的permission取出

        if (permissionList != null){

            HashSet<String> strings = new HashSet<>();

            for (Permission permission : permissionList) {
                strings.add(permission.getPermission());
            }
            System.out.println(strings);
            simpleAuthorizationInfo.addStringPermissions(strings);

            return simpleAuthorizationInfo;
        }

        //simpleAuthorizationInfo.addRoles();

        return simpleAuthorizationInfo;
    }

    /**
     * 认证  token
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //先进行一波判断 看看token是否为零

        if(authenticationToken == null || StringUtils.isBlank((String) authenticationToken.getPrincipal())){
            return null;
        }
        //关注凭证也就是密码
        //执行验证用户
        //从taken中取出用户信息 token是用户给的
        String  username = (String) authenticationToken.getPrincipal();
        //根据用户名去查询信息看看数据库中有这号人物不
        Admin admin = adminService.queryPasswordByUsername(username);

        if ( admin == null ){
            return null;
        }

        /*
        * 第一个参数是给授权用的
        * 第二个参数通常是密码 若与subject，login中的token的密码相匹配则通过认证
        * 第三个参数当前域名 通常没有用
        * */
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(admin.getUsername(), admin.getPassword(),this.getName());

        return simpleAuthenticationInfo;
    }
}
