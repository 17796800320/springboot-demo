package com.tm.service;

import com.tm.entity.PermissionEntity;

import java.util.List;

public interface PermissionService {
    List<PermissionEntity> listAllPermission(PermissionEntity permission);

    void permissionadd(PermissionEntity permission);

    void permissionUpdate(PermissionEntity permission);

    void permissionDelete(List<Integer> ids);

    List<PermissionEntity> permissionMenuList();
}
