package com.tm.service;

import com.tm.entity.Dept;

import java.util.List;

public interface DeptService {


    List<Dept> deptlistAll();

    void insertDept(Dept dept);

    void updateDept(Dept dept);

    void deleteDept(List<Integer> ids);
}
