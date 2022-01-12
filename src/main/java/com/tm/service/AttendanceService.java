package com.tm.service;

import com.tm.entity.AttendanceEntity;

import java.util.List;

public interface AttendanceService {
    List<AttendanceEntity> queryAttendance(AttendanceEntity attendanceEntity);
}
