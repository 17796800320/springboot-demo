package com.tm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
//Swagger提供的api注解
@ApiModel(value = "角色实体类")
public class RoleEntity {

    @ApiModelProperty("序号")
    private Integer id;
    @ApiModelProperty("角色名称")
    private String name;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("备注角色")
    private String remark;
    @ApiModelProperty("角色创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @ApiModelProperty("角色修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
    private List<PermissionEntity> perList;

}
