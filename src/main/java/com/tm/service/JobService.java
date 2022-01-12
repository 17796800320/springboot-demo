package com.tm.service;

import com.tm.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> listAll();

    void insertJob(Job job);

    void update(Job job);

    void delete(List<Integer> ids);
}
