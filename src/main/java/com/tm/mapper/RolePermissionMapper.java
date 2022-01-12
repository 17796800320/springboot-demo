package com.tm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface RolePermissionMapper {
    void addRolePermission(@Param("map") Map<String, Object> map);

    void deleteRolePermission(Object id);
}
