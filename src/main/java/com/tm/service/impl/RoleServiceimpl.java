package com.tm.service.impl;

import com.tm.entity.RoleEntity;
import com.tm.mapper.RoleMapper;
import com.tm.mapper.RolePermissionMapper;
import com.tm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceimpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;


    @Override
    public List<RoleEntity> rolelistAll(RoleEntity roleEntity) {
        return roleMapper.rolelistAll(roleEntity);
    }

    @Override
    public void deleteRole(Integer id) {
        roleMapper.deleteRole(id);
        roleMapper.deleteRolePer(id);
    }

    @Override
    public void deleteAll(List<Integer> ids) {
        roleMapper.deleteAll(ids);
    }

    @Override
    public void roleadd(RoleEntity roleEntity) {
        //判断角色是否存在
        List<RoleEntity> list = roleMapper.getByRoleName(roleEntity.getName());

        //如果存在则不让继续新增
        if (list.size() > 0){
            throw new RuntimeException("角色已经存在");
        }
        roleMapper.roleadd(roleEntity);
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        roleMapper.updateRole(roleEntity);
    }

    @Override
    public void modifyPermission(Map<String, Object> map) {
        //删除当前角色所有的权限
        rolePermissionMapper.deleteRolePermission(map.get("id"));
        //新增权限
        rolePermissionMapper.addRolePermission(map);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleEntity> getRolebyUserId(Integer id) {
        return roleMapper.getRolebyUserId(id);
    }

}
