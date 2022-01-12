package com.tm.controller;

import com.tm.entity.AttendanceEntity;
import com.tm.service.AttendanceService;
import com.tm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("att")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public Result queryAttendance(AttendanceEntity attendanceEntity){
        List<AttendanceEntity> list = attendanceService.queryAttendance(attendanceEntity);
        return Result.success(list);
    }


}
