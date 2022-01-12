package com.tm.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.tm.entity.UserEntity;
import com.tm.service.UserService;
import com.tm.utils.PageBean;
import com.tm.utils.Result;
import com.tm.vo.UpdateUserRoleVo;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("noLogin")
    public String abc(){
        return "用户未登录";
    }

    //登录
    @ApiOperation(value = "用户登录", notes = "user:login")
    @PostMapping("login")
    public Result login(@RequestBody UserEntity userEntity){
        UsernamePasswordToken token = new UsernamePasswordToken(userEntity.getUsername(),userEntity.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return Result.success();
    }

    //注销
    @ApiOperation(value = "用户注销", notes = "user:logout")
    @GetMapping("logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    //注册
    @ApiOperation(value = "用户注册", notes = "user:register")
    @PostMapping("register")
    public Result register(@RequestBody UserEntity entity){
        userService.register(entity);
        return Result.success();
    }

    //瑞快斯跑米森
    @RequiresPermissions("user:userlistAll")
    @ApiOperation(value = "查询用户", notes = "user:userlistAll")
    @GetMapping
    public Result userlistAll(UserEntity user, PageBean pageBean){
        pageBean = userService.userlistAll(user,pageBean);
        return Result.success(pageBean);
    }

    @RequiresPermissions("user:userinsert")
    @ApiOperation(value = "新增用户", notes = "user:userinsert")
    @PostMapping("/{arrIds}")
    public Result userinsert(@RequestBody UserEntity user,@PathVariable List<Integer> arrIds){
        userService.userinsert(user,arrIds);
        return Result.success(user);
    }

    @RequiresPermissions("user:userupdate")
    @ApiOperation(value = "修改用户启用状态", notes = "user:userupdate")
    @PutMapping("/{arrIds}")
    public Result userupdate(@RequestBody UserEntity user,@PathVariable List<Integer> arrIds){
        userService.userupdate(user,arrIds);
        return Result.success(user);
    }

    @RequiresPermissions("user:userupdates")
    @ApiOperation(value = "修改用户", notes = "user:userupdates")
    @PutMapping
    public Result userupdates(@RequestBody UserEntity user){
        userService.userupdates(user);
        return Result.success(user);
    }

    @RequiresPermissions("user:updateUserRole")
    @ApiOperation(value = "修改用户的角色", notes = "user:updateUserRole")
    @PutMapping("updateUserRole")
    public Result updateUserRole(@RequestBody UpdateUserRoleVo updateUserRoleVo){
        userService.updateUserRole(updateUserRoleVo);
        return Result.success();
    }

    @RequiresPermissions("user:deleteuser")
    @ApiOperation(value = "删除用户", notes = "user:deleteuser")
    @DeleteMapping("/{id}")
    public Result deleteuser(@PathVariable Integer id){
        userService.deleteuser(id);
        return Result.success(id);
    }

    //导入
    @PostMapping("daoru")
    public Result daotu(){
        List<UserEntity> list = new ArrayList<>();
        EasyExcel.read("C:\\Users\\admin\\Desktop\\用户信息.xlsx", UserEntity.class, new AnalysisEventListener<UserEntity>() {
            @Override
            public void invoke(UserEntity userEntity, AnalysisContext analysisContext) {
                list.add(userEntity);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("导入完成");
            }
        }).sheet("用户信息").doRead();
        for (int i = 0; i < list.size(); i++) {
            userService.userinsert(list.get(i),null);
        }
        return Result.success(list.size());
    }

}
