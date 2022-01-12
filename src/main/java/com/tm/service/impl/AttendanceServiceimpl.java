package com.tm.service.impl;

import com.tm.entity.AttendanceEntity;
import com.tm.mapper.AttendanceMapper;
import com.tm.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceimpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public List<AttendanceEntity> queryAttendance(AttendanceEntity attendanceEntity) {
        attendanceMapper.queryAttendance(attendanceEntity);
        return null;
    }
}
