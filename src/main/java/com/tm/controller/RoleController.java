package com.tm.controller;

import com.tm.entity.RoleEntity;
import com.tm.service.RoleService;
import com.tm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("role")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET,RequestMethod.POST})
@Api(tags = "角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequiresPermissions("role:rolelistAll")
    @ApiOperation(value = "查询角色", notes = "role:rolelistAll")
    @GetMapping
    public Result rolelistAll(RoleEntity roleEntity){
        List<RoleEntity> list = roleService.rolelistAll(roleEntity);
        return Result.success(list);
    }

    @RequiresPermissions("role:rolelistAll")
    @ApiOperation(value = "新增角色", notes = "role:rolelistAll")
    @PostMapping
    //路径传参 PathVariable获取路径的参数
    public Result roleadd(@RequestBody RoleEntity roleEntity){
        roleService.roleadd(roleEntity);
        return Result.success(roleEntity);
    }

    @RequiresPermissions("role:modifyPermission")
    @ApiOperation(value = "修改角色的权限", notes = "role:modifyPermission")
    @PostMapping("modifyPermission")
    //路径传参 PathVariable获取路径的参数
    public Result modifyPermission(@RequestBody Map<String,Object> map){
        roleService.modifyPermission(map);
        return Result.success(map);
    }

    @RequiresPermissions("role:getRolebyUserId")
    @ApiOperation(value = "根据用户查询角色", notes = "role:getRolebyUserId")
    @GetMapping("getRolebyUserId")
    public Result getRolebyUserId(Integer id){
        List<RoleEntity> list = roleService.getRolebyUserId(id);
        return Result.success(list);
    }

    @RequiresPermissions("role:deleteRole")
    @ApiOperation(value = "删除角色", notes = "role:deleteRole")
    @DeleteMapping("/{id}")
    public Result deleteRole(@PathVariable Integer id){
        roleService.deleteRole(id);
        return Result.success(id);
    }

    @RequiresPermissions("role:deleteAll")
    @ApiOperation(value = "删除角色的对应的权限", notes = "role:deleteAll")
    @DeleteMapping
    public Result deleteAll(@RequestBody List<Integer> ids){
        roleService.deleteAll(ids);
        return Result.success(ids);
    }

    @RequiresPermissions("role:updateRole")
    @ApiOperation(value = "修改角色", notes = "role:updateRole")
    @PutMapping
    public Result updateRole(@RequestBody RoleEntity roleEntity){
        roleService.updateRole(roleEntity);
        return Result.success();
    }

}
