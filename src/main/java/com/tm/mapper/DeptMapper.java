package com.tm.mapper;

import com.tm.entity.Dept;
import com.tm.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {


    List<Dept> deptlistAll();

    void insertDept(Dept dept);

    void updateDept(Dept dept);

    void deleteDept(List<Integer> deleteIds);

}
