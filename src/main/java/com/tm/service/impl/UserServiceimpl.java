package com.tm.service.impl;

import com.tm.entity.UserEntity;
import com.tm.mapper.UserMapper;
import com.tm.mapper.UserRoleMapper;
import com.tm.service.UserService;
import com.tm.utils.CustomException;
import com.tm.utils.Md5Enum;
import com.tm.utils.PageBean;
import com.tm.vo.UpdateUserRoleVo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public PageBean userlistAll(UserEntity user, PageBean pageBean) {
        List<UserEntity> list = userMapper.userlistAll(user,pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setList(list);
        //查询总条数
        Integer count = userMapper.userlistAllCount(user);
        pageBean.setTotal(count);
        return pageBean;
    }


    @Override
    public void deleteuser(Integer id) {
        userMapper.deleteUserRole(id);
        userMapper.deleteuser(id);
    }

    @Override
    public void userinsert(UserEntity user, List<Integer> arrIds) {
        //判断岗位名称是否存在
        List<UserEntity> list = userMapper.getUserByName(user.getUsername());
        //如果存在则不让继续新增
        if (list.size() > 0){
            throw new RuntimeException("岗位已经存在");
        }
        user.setPassword(new Md5Hash(user.getPassword(), Md5Enum.SALT,1024).toHex());
        userMapper.userinsert(user);
        Integer id = user.getId();
        userMapper.userRoleinsert(id,arrIds);

    }

    @Override
    public void userupdate(UserEntity user, List<Integer> arrIds) {
        int id = user.getId();
        userMapper.deleteUserRole(id);
        userMapper.userRoleinsert(id,arrIds);
        user.setPassword(new Md5Hash(user.getPassword(), Md5Enum.SALT,1024).toHex());
        userMapper.userupdate(user);
    }

    @Override
    public void userupdates(UserEntity user) {
        if (user.getStatus() == 0){
            //查询当前角色是否有用户使用
            int count = userRoleMapper.getByRoleId(user.getId());
            if (count > 0){
                throw new CustomException("当前用户已有人使用，无法禁用");
            }
        }
        //对密码加密
        user.setPassword(new Md5Hash(user.getPassword(), Md5Enum.SALT,1024).toHex());
        userMapper.userupdates(user);
    }

    @Override
    public void register(UserEntity entity) {
        //对密码加密
        entity.setPassword(new Md5Hash(entity.getPassword(), Md5Enum.SALT,1024).toHex());
        userMapper.userinsert(entity);
    }

    @Override
    public void updateUserRole(UpdateUserRoleVo updateUserRoleVo) {
        //删除当前用户的所有角色
        userMapper.deleteUserRole(updateUserRoleVo.getUserId());
        //新增当前用户的角色

        if (updateUserRoleVo.getAllocRoleIds() != null && updateUserRoleVo.getAllocRoleIds().size() > 0 ){
            userRoleMapper.insertData(updateUserRoleVo);
        }
    }

}
