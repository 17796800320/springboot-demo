package com.tm.mapper;

import com.tm.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<RoleEntity> rolelistAll(@Param("roleEntity") RoleEntity roleEntity);

    void roleadd(RoleEntity roleEntity);

    void deleteRole(Integer id);

    void deleteAll(@Param("ids") List<Integer> ids);

    List<RoleEntity> getByRoleName(String name);

    void addrole(@Param("rolId")int rolId, @Param("idArr")List<Integer> idArr);

    void updateRole(RoleEntity roleEntity);

    void deleteRolePer(Integer id);

    List<RoleEntity> getRolebyUserId(Integer id);
}
