package com.tm.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Dept {

    private Integer id;
    private String name;
    private Integer pid;
    private String parentName;
    private Integer leaderId;
    private String tel;
    private String email;
    private String fax;
    private String remark;
    private Integer sortNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
