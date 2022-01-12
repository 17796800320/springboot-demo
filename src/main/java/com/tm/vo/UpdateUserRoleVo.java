package com.tm.vo;

import lombok.Data;

import java.util.List;

@Data
public class UpdateUserRoleVo {

    private Integer userId;
    private List<Integer> allocRoleIds;
}
