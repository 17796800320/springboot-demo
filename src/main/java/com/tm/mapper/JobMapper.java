package com.tm.mapper;

import com.tm.entity.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {

    List<Job> listAll();

    void insertJob(Job job);

    List<Job> getJobByName(String name);

    void update(Job job);

    void delete(List<Integer> deleteIds);
}
