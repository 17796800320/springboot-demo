package com.tm.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//规定当前表中谁是主键
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TmTableId {

}
