/*package com.tm.config;

import org.springframework.http.HttpHeaders;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;*/

//*
// * @author lichuan
// * @version 1.0
// * @description: TODO
// * @date 2021/8/3 10:36

/*import org.springframework.http.HttpHeaders;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //HttpServletResponse
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //设置允许跨域请求的源
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:8081");
        //设置允许跨域请求的请求头
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "content-type,contentType");
        //设置允许跨域请求的请求方式(get,post,delete,put)
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,DELETE,PUT");
        //设置发送跨域请求时允许携带Cookie
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,"true");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取客户端请求方式
        String method = request.getMethod();
        //如果是OPTIONS请求，也就是预检请求就不让请求继续向下执行
        if(!method.equalsIgnoreCase("options")){
            //过滤器链
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}*/
