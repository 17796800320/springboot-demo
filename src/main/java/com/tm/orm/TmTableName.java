package com.tm.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//当前注解规定我们orm框架中的表名
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TmTableName {

    String value() default "";

}
