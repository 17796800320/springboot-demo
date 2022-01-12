package com.tm.mapper;

import com.tm.vo.UpdateUserRoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {
    int getByRoleId(Integer id);

    void insertData(@Param("vo")UpdateUserRoleVo updateUserRoleVo);
}
