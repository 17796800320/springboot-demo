package com.tm.service.impl;

import com.tm.entity.Job;
import com.tm.mapper.JobMapper;
import com.tm.service.JobService;
import io.swagger.models.auth.In;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobServiceimpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Job> listAll() {
        return jobMapper.listAll();
    }

    @Override
    public void insertJob(Job job){
        //判断岗位名称是否存在
        List<Job> list = jobMapper.getJobByName(job.getName());
        //如果存在则不让继续新增
        if (list.size() > 0){
            throw new RuntimeException("岗位已经存在");
        }
        jobMapper.insertJob(job);
    }

    @Override
    public void update(Job job) {
        jobMapper.update(job);
    }

    @Override
    public void delete(List<Integer> ids) {
        //查询所有岗位
        List<Job> jobs = jobMapper.listAll();

        //定义一个list集合存放要删除的id
        List<Integer> deleteIds = new ArrayList<>();
        for (Integer id : ids) {
            deleteIds.add(id);
            eachList(deleteIds,jobs,id);
        }

        //去重
        deleteIds = deleteIds.stream().distinct().collect(Collectors.toList());

        jobMapper.delete(deleteIds);

    }


    public void eachList(List<Integer> deleteIds,List<Job> list,Integer id){

        for (Job job : list) {
            if (job.getPid() == id){
                deleteIds.add(job.getId());
                eachList(deleteIds,list,job.getId());
            }
        }
    }

}
