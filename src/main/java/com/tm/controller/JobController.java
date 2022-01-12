package com.tm.controller;

import com.tm.entity.Job;
import com.tm.service.JobService;
import com.tm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("job")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@Api(tags = "部门管理")
public class JobController {

    @Autowired
    private JobService jobService;

    @RequiresPermissions("job:listAll")
    @GetMapping
    @ApiOperation(value = "查询所有岗位",notes = "job:listAll")
    public Result listAll(){
        List<Job> list = jobService.listAll();
        return Result.success(list);
    }

    @RequiresPermissions("job:insertJob")
    @PostMapping
    @ApiOperation(value = "新增岗位",notes = "job:insertJob")
    public Result insertJob(@RequestBody Job job){
       jobService.insertJob(job);
        return Result.success();
    }

    @RequiresPermissions("job:update")
    @ApiOperation(value = "修改岗位",notes = "job:update")
    @PutMapping
    public Result update(@RequestBody Job job){
        try {
            jobService.update(job);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    @RequiresPermissions("job:delete")
    @ApiOperation(value = "删除岗位",notes = "job:delete")
    @DeleteMapping
    public Result delete(@RequestBody List<Integer> ids){
        jobService.delete(ids);
        return Result.success();
    }

}
