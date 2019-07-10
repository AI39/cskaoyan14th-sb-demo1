package com.cskaoyan14th.shiro;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.aspectj.weaver.ast.Var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public DefaultWebSecurityManager securityManager (CustomRealm customRealm,MallShiroSessionManager mallShiroSessionManager){

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setSessionManager(mallShiroSessionManager);
        defaultWebSecurityManager.setRealm(customRealm);

        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        shiroFilterFactoryBean.setLoginUrl("/admin/auth/login");
        HashMap<String, String> filterMap = new HashMap<>();
        filterMap.put("/admin/auth/login","anon");
        filterMap.put("/admin/auth/info","anon");
        filterMap.put("/admin/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return  shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor  authorizationAttributeSourceAdvisor (DefaultWebSecurityManager defaultWebSecurityManager){

        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);

        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public MallShiroSessionManager mallShiroSessionManager(){

        MallShiroSessionManager mallShiroSessionManager = new MallShiroSessionManager();

        return mallShiroSessionManager;
    }
}
