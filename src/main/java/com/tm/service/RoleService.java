package com.tm.service;

import com.tm.entity.RoleEntity;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<RoleEntity> rolelistAll(RoleEntity roleEntity);

    void deleteRole(Integer id);

    void deleteAll(List<Integer> ids);

    void roleadd(RoleEntity roleEntity);

    List<RoleEntity> getRolebyUserId(Integer id);

    void updateRole(RoleEntity roleEntity);

    void modifyPermission(Map<String, Object> map);
}
