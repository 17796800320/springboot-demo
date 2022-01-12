package com.tm.mapper;

import com.tm.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserEntity> userlistAll(@Param("user") UserEntity user, @Param("startIndex")Integer startIndex, @Param("pageSize")Integer pageSize);

    void userinsert(UserEntity user);

    List<UserEntity> getUserByName(String username);

    void userupdate(UserEntity user);

    void deleteuser(Integer id);

    void userRoleinsert(@Param("id") Integer id,@Param("arrIds") List<Integer> arrIds);

    void deleteUserRole(Integer id);

    void userupdates(UserEntity user);

    UserEntity getUserByNamequery(String principal);

    Integer userlistAllCount(@Param("user") UserEntity user);

    List<String> getPermissionByName(String principal);
}
