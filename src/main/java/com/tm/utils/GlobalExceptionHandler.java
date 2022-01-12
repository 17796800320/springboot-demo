package com.tm.utils;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //异常
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e){
        LOGGER.error("异常！",e);
        return Result.error();
    }

    //账号不存在
    @ExceptionHandler(UnknownAccountException.class)
    public Result handlerException(UnknownAccountException e){
        LOGGER.error("账号不存在",e);
        return Result.error();
    }

    //密码错误
    @ExceptionHandler(IncorrectCredentialsException.class)
    public Result handlerException(IncorrectCredentialsException e){
        LOGGER.error("密码错误",e);
        return Result.error();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handlerException(MethodArgumentNotValidException e){
        LOGGER.error("效验失败！");
        return Result.error("效验失败");
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handlerException(NullPointerException e){
        LOGGER.error("空指针异常！",e);
        return Result.error("空指针异常！");
    }

    @ExceptionHandler(NumberFormatException.class)
    public Result handlerException(NumberFormatException e){
        LOGGER.error("数值转换异常！",e);
        return Result.error("数值转换异常！");
    }

    @ExceptionHandler(CustomException.class)
    public Result CustomException(Exception e){
        LOGGER.error("异常！");
        return Result.error(e.getMessage());
    }

    //没有权限
    @ExceptionHandler(UnauthorizedException.class)
    public Result CustomException(UnauthorizedException e){
        LOGGER.error("你没有权限！"+e.getMessage());
        return Result.unError("没有权限");
    }

    //用户未登录
    @ExceptionHandler(UnauthenticatedException.class)
    public Result handlerException(UnauthenticatedException e){
        LOGGER.error("用户未登录！"+e.getMessage());
        return Result.authenError("用户未登录");
    }

}
