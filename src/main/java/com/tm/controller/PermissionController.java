package com.tm.controller;

import com.tm.entity.PermissionEntity;
import com.tm.service.PermissionService;
import com.tm.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("per")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequiresPermissions("per:listAllPermission")
    @ApiOperation(value = "查询权限", notes = "role:listAllPermission")
    @GetMapping
    public Result listAllPermission(PermissionEntity permission){
        List<PermissionEntity> list = permissionService.listAllPermission(permission);
        return Result.success(list);
    }

    @ApiOperation(value = "查询菜单权限", notes = "per:permissionMenuList")
    @GetMapping("permissionMenuList")
    public Result permissionMenuList(){
        List<PermissionEntity> list = permissionService.permissionMenuList();
        return Result.success(list);
    }

    @RequiresPermissions("per:permissionadd")
    @ApiOperation(value = "新增权限", notes = "role:permissionadd")
    @PostMapping
    public Result permissionadd(@RequestBody PermissionEntity permission){
        permissionService.permissionadd(permission);
        return Result.success();
    }

    @RequiresPermissions("per:permissionUpdate")
    @ApiOperation(value = "修改权限", notes = "role:permissionUpdate")
    @PutMapping
    public Result permissionUpdate(@RequestBody PermissionEntity permission){
        permissionService.permissionUpdate(permission);
        return Result.success();
    }

    @RequiresPermissions("per:permissionDelete")
    @ApiOperation(value = "删除权限", notes = "role:permissionDelete")
    @DeleteMapping
    public Result permissionDelete(@RequestBody List<Integer> ids){
        permissionService.permissionDelete(ids);
        return Result.success();
    }

}
