package com.tm.service.impl;

import com.tm.entity.Dept;
import com.tm.entity.PermissionEntity;
import com.tm.mapper.PermissionMapper;
import com.tm.service.PermissionService;
import lombok.val;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionServiceimpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<PermissionEntity> listAllPermission(PermissionEntity permission) {
        return permissionMapper.listAllPermission();
    }

    @Override
    public void permissionadd(PermissionEntity permission) {
        permissionMapper.permissionadd(permission);
    }

    @Override
    public void permissionUpdate(PermissionEntity permission) {
        permissionMapper.permissionUpdate(permission);
    }

    @Override
    public void permissionDelete(List<Integer> ids) {
        //查询所有岗位
        List<PermissionEntity> permission = permissionMapper.listAllPermission();

        //定义一个list集合存放要删除的id
        List<Integer> deleteIds = new ArrayList<>();
        for (Integer id : ids) {
            deleteIds.add(id);
            eachList(deleteIds,permission,id);
        }

        //去重
        deleteIds = deleteIds.stream().distinct().collect(Collectors.toList());

        permissionMapper.permissionDelete(deleteIds);
    }

    @Override
    public List<PermissionEntity> permissionMenuList() {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String)subject.getPrincipal();
        return permissionMapper.permissionMenuList(principal);
    }

    public void eachList(List<Integer> deleteIds,List<PermissionEntity> list,Integer id){

        for (PermissionEntity permission : list) {
            if (permission.getPid() == id){
                deleteIds.add(permission.getId());
                eachList(deleteIds,list,permission.getId());
            }
        }
    }

}
