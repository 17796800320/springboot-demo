package com.tm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "用户封装类")
public class UserEntity extends BaseEntity{

    @ApiModelProperty("工号")
    private String jobNumber;
    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty("姓名")
    private String realName;
    @ApiModelProperty("邮箱")
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("入职日期")
    private Date enterDate;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("岗位id")
    private Integer positionId;
    @ApiModelProperty("部门id")
    private Integer deptId;
    @ApiModelProperty("手机号")
    private String phoneNumber;
    @ApiModelProperty("头像地址")
    private String avatarUrl;
    @ApiModelProperty("性别")
    private Integer sex;
    @ApiModelProperty("排序号")
    private Integer sortNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("生日")
    private Date birthday;

}
