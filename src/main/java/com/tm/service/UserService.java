package com.tm.service;

import com.tm.entity.UserEntity;
import com.tm.utils.PageBean;
import com.tm.vo.UpdateUserRoleVo;

import java.util.List;

public interface UserService {
    PageBean userlistAll(UserEntity user, PageBean pageBean);

    void deleteuser(Integer id);

    void userinsert(UserEntity user, List<Integer> arrIds);

    void userupdate(UserEntity user, List<Integer> arrIds);

    void userupdates(UserEntity user);

    void register(UserEntity entity);

    void updateUserRole(UpdateUserRoleVo updateUserRoleVo);

}
