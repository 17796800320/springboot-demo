package com.tm.utils;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    public Result(ResultCode resultCode,Object data){
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
    }

    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    //添加静态方法
    public static Result success(){
        return new Result(ResultCode.SUCCESS);
    }

    //添加静态方法
    public static Result success(Object data){
        return new Result(ResultCode.SUCCESS,data);
    }

    //添加静态方法
    public static Result error(){
        Result r = new Result(ResultCode.ERROR);
        return r;
    }

    public static Result error(Object data){
        return new Result(ResultCode.ERROR,data);
    }

    public static Result unError(Object data){
        return new Result(ResultCode.UNERROR,data);
    }

    public static Result authenError(Object data){
        return new Result(ResultCode.AUTHENERROR,data);
    }

}
