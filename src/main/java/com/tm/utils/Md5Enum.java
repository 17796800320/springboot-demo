package com.tm.utils;

public class Md5Enum {

    /**
     * 对"123456"直接md5结果
     */
    public static final String HEX1 = "e10adc3949ba59abbe56e057f20f883e";
    /**
     * 对"123456",盐为"ABCDE"的md5结果
     */
    public static final String HEX2 = "8cdcdd77a21a5f80e3a88a013bc957f8";
    /**
     * 对"123456",盐为"ABCDE",散列1024次的md5结果
     */
    public static final String HEX3 = "abadd954d2234843108de678396229e5";
    /**
     * 盐值
     */
    public static final String SALT="ABCDE";



}
