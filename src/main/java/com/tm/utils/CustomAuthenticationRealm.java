package com.tm.utils;

import com.tm.entity.UserEntity;
import com.tm.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomAuthenticationRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    //Custom 自定义 查询数据库的数据

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("方法被调用");

        String principal = (String) token.getPrincipal();
//        System.out.println(principal);

        //模拟数据库数据
//        String username = "zs";
//        String password = Md5Enum.HEX3;
        UserEntity user = userMapper.getUserByNamequery(principal);

        //判断用户是否正确
        if (null != user){
            //判断密码是否正确
            return new SimpleAuthenticationInfo(principal,user.getPassword(), ByteSource.Util.bytes(Md5Enum.SALT),this.getName());
        }

        return null;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //获取主身份
        String principal= (String) principals.getPrimaryPrincipal();
//        System.out.println("执行了授权操作:doGetAuthorizationInfo:" + principal);

        //进行授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        List<String> list = userMapper.getPermissionByName(principal);

//        //赋予角色
//        authorizationInfo.addRole("root");
//
//        //赋予权限(单个)
//        authorizationInfo.addStringPermission("user:userlistAll");
//
//        //赋予权限多个
//        List<String> list = new ArrayList<>();
//        list.add("user:userinsert");
//        list.add("user:userupdate");
//        list.add("user:deleteuser");
//        list.add("dept:query");

        authorizationInfo.addStringPermissions(list);

        return authorizationInfo;
    }

}
