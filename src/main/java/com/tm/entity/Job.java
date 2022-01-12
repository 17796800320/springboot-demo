package com.tm.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Job extends BaseEntity{

//    @NotBlank(message = "品牌名称不能为空")
//    @Length(min = 1,max = 255,message = "品牌名称在1到255个字符之间")
    @ApiModelProperty(value = "岗位名称",required = true,dataType = "String")
    private String name;
    private Integer pid;
    private String serialNumber;
    private String responsibility;
    private String remark;
//    @IdCard
    private Integer idCard;
    private Integer sortNumber;

}
