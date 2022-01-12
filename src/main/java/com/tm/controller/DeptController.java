package com.tm.controller;

import com.tm.entity.Dept;
import com.tm.service.DeptService;
import com.tm.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dept")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequiresPermissions("dept:dept")
    @ApiOperation(value = "查询部门",notes = "dept:dept")
    @GetMapping
    public Result dept(){
        List<Dept> list = deptService.deptlistAll();
        return Result.success(list);
    }

    @RequiresPermissions("dept:insertDept")
    @ApiOperation(value = "新增部门",notes = "dept:insertDept")
    @PostMapping
    public Result insertDept(@RequestBody Dept dept){
        deptService.insertDept(dept);
        return Result.success();
    }

    @RequiresPermissions("dept:updateDept")
    @ApiOperation(value = "修改部门",notes = "dept:updateDept")
    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateDept(dept);
        return Result.success();
    }

    @RequiresPermissions("dept:deleteDept")
    @ApiOperation(value = "删除部门",notes = "dept:deleteDept")
    @DeleteMapping
    public Result deleteDept(@RequestBody List<Integer> ids){
        deptService.deleteDept(ids);
        return Result.success();
    }



}
