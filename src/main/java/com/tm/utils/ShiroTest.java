package com.tm.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

public class ShiroTest {
    public static void main(String[] args) {

        //创建一个安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        //使用IniRealm需要扫描配置的shiro.ini配置文件到realm
        //IniRealm realm = new IniRealm("classpath:shiro.ini");

        //使用自定义realm则不需要扫描
        CustomAuthenticationRealm realm = new CustomAuthenticationRealm();

        //设置md5加密
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher("MD5");
        credentialsMatcher.setHashIterations(1024); //散列到1024次 散列的次数 MD5(MD5(...(你的密码)))
        realm.setCredentialsMatcher(credentialsMatcher);

        //将Realm设置给安全管理器
        securityManager.setRealm(realm);

        //将默认安全管理器 设置给 安全工具类中
        SecurityUtils.setSecurityManager(securityManager);

        //获取主体
        Subject subject = SecurityUtils.getSubject();

        //定义一个token
        //前台穿过来的参数
        UsernamePasswordToken token = new UsernamePasswordToken("zs","123456");

        //登录
            /*
            •   DisabledAccountException（帐号被禁用）
            •	LockedAccountException（帐号被锁定）
            •	ExcessiveAttemptsException（登录失败次数过多）
            •	ExpiredCredentialsException（凭证过期）等
            */

        try {
            subject.login(token);
            System.out.println("登陆成功");
        } catch (UnknownAccountException e){
            System.out.println("账号不存在");
        } catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        } catch (AuthenticationException e){
            System.out.println("认证失败");
        }

        //注销 退出
        subject.logout();

        //md5+盐zhi+散列多少次的算法
        Object salt = ByteSource.Util.bytes("ABCDE");
        Md5Hash md5Hash = new Md5Hash("123456", salt, 1024);
        String s = md5Hash.toHex();
        System.out.println(s);


    }
}
