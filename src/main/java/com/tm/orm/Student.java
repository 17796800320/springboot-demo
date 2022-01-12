package com.tm.orm;

//规定当前类所对应的表名
@TmTableName("t_student")
public class Student {

    @TmTableId
    @TmPropertyName("student_id")
    private Integer studentId;

    @TmPropertyName("student_name")
    private String studentName;

    @TmPropertyName("student_sex")
    private String studentSex;

    @TmPropertyName("student_age")
    private Integer studentAge;

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


}
