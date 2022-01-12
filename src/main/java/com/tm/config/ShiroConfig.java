package com.tm.config;

import com.tm.utils.CustomAuthenticationRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfig {

    // 加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //配置Shiro的Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        factoryBean.setSecurityManager(securityManager);

        //Map<String, String> filterMap = new HashMap<>();

         /*
            anon: 无需认证
            authc: 必须认证且授权
            user: 必须拥有 记住我 才可以访问
            perms: 拥有某个资源权限才能访问（权限）
            role: 拥有某个角色权限才能访问（角色）
         */
        //filterMap.put("/dept","authc");

        //放开登录
        //filterMap.put("/user/login","anon");

        //批量放开 一个* 和 两个* 的区别：
        // 一个* 只会放开当前层级 比如/user/add
        // 两个* 会放开所有层级 比如/user/add/01
        //filterMap.put("/user/**","anon");


        //factoryBean.setFilterChainDefinitionMap(filterMap);

        //未登录跳转的页面
        //factoryBean.setLoginUrl("/user/noLogin");
        //首页 认证通过跳转
        //factoryBean.setSuccessUrl("/index.jsp");
        //错误页面，认证不通过跳转
        //factoryBean.setUnauthorizedUrl("/error");

        return factoryBean;
    }

    // 权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager(CustomAuthenticationRealm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    //自定义realm 并把密码匹配器注入
    @Bean
    public CustomAuthenticationRealm customAuthorizationRealm(HashedCredentialsMatcher credentialsMatcher){
        CustomAuthenticationRealm realm = new CustomAuthenticationRealm();
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }

    //密码匹配器
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        return matcher;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

}
