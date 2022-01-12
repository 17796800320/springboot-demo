package com.tm.service.impl;

import com.tm.entity.Dept;
import com.tm.entity.Job;
import com.tm.mapper.DeptMapper;
import com.tm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DeptServiceimpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> deptlistAll() {
        return deptMapper.deptlistAll();
    }

    @Override
    public void insertDept(Dept dept) {
        deptMapper.insertDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }

    @Override
    public void deleteDept(List<Integer> ids) {
        //查询所有岗位
        List<Dept> depts = deptMapper.deptlistAll();

        //定义一个list集合存放要删除的id
        List<Integer> deleteIds = new ArrayList<>();
        for (Integer id : ids) {
            deleteIds.add(id);
            eachList(deleteIds,depts,id);
        }

        //去重
        deleteIds = deleteIds.stream().distinct().collect(Collectors.toList());

        deptMapper.deleteDept(deleteIds);
    }

    public void eachList(List<Integer> deleteIds,List<Dept> list,Integer id){

        for (Dept dept : list) {
            if (dept.getPid() == id){
                deleteIds.add(dept.getId());
                eachList(deleteIds,list,dept.getId());
            }
        }
    }

}
