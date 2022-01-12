package com.tm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class PermissionEntity {

    private Integer id;
    private String name;    //权限名称
    private Integer pid;    //上级权限ID
    private String permissionIdentifier;   //权限标识符
    private String url;    //权限地址
    private Integer type;   //类型：1菜单 2按钮
    private String icon;   //图标样式
    private Integer sortNumber;   //排序号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;   //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;       //修改时间

}
