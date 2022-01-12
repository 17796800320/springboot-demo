package com.tm.utils;

import org.apache.shiro.authz.UnauthorizedException;

//枚举类
public enum ResultCode {

    SUCCESS(200,"访问成功"),
    NOTFOUNT(404,"找不到资源路径"),
    ERROR(500,"访问失败"),
    UNERROR(403,"您没有权限"),
    AUTHENERROR(406,"用户未登录");

    private Integer code;
    private String msg;

    //定义一个构造函数
    ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}
