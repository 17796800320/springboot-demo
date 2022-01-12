package com.tm.orm;

import java.util.Date;

public class StudentDemo {

    private Integer studentId;

    private String studentName;

    private String studentSex;

    private Integer studentAge;

    public Date StudentBirthday;

    public String studentAddr;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Date getStudentBirthday() {
        return StudentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        StudentBirthday = studentBirthday;
    }

    public String getStudentAddr() {
        return studentAddr;
    }

    public void setStudentAddr(String studentAddr) {
        this.studentAddr = studentAddr;
    }
}
