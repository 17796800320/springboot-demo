package com.tm.mapper;

import com.tm.entity.PermissionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    List<PermissionEntity> listAllPermission();

    void permissionadd(PermissionEntity permission);

    void permissionUpdate(PermissionEntity permission);

    void permissionDelete(List<Integer> deleteIds);

    List<PermissionEntity> permissionMenuList(String principal);
}
