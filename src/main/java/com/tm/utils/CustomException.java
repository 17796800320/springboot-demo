package com.tm.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//自定义异常类
public class CustomException extends RuntimeException{

    private Integer errorCode;
    private String errorMessage;

    public CustomException(ResultCode resultCode){
        this.errorCode = resultCode.getCode();
        this.errorMessage = resultCode.getMsg();
    }

    public CustomException(String errorMessage){
        this.errorMessage = errorMessage;
    }

}
