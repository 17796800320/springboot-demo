package com.tm.mapper;

import com.tm.entity.AttendanceEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendanceMapper {
    void queryAttendance(AttendanceEntity attendanceEntity);
}
