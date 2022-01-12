package com.tm.orm;

import lombok.val;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Poi {

    public static void main(String[] args) throws IOException {

        List<StudentDemo> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            StudentDemo studentDemo = new StudentDemo();
            studentDemo.setStudentId(i+1);
            studentDemo.setStudentName("张三"+i);
            studentDemo.setStudentSex("男");
            studentDemo.setStudentAge(5+i);
            studentDemo.setStudentBirthday(new Date());

            list.add(studentDemo);
            System.out.println(list.get(i));
        }


        //导出：指的是将从数据库查出来的数据，赋值到excel文件中
        //导入：获取用户上传的excel文件，将数据插入到数据库中
        //创建excel对象
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建sheet页对象
        XSSFSheet sheet = workbook.createSheet("学生信息");
        //通过sheet页创建行对象
        XSSFRow row = sheet.createRow(0);
        //通过第一行的行对象，创建表头
        XSSFCell cell0 = row.createCell(0);  //第一行第一个单元格
        XSSFCell cell1 = row.createCell(1);  //第一行第二个单元格
        XSSFCell cell2 = row.createCell(2);  //第一行第三个单元格
        XSSFCell cell3 = row.createCell(3);  //第一行第四个单元格
        XSSFCell cell4 = row.createCell(4);  //第一行第五个单元格
        //有单元格之后，可以对单元格进行赋值
        cell0.setCellValue("学生编号");
        cell1.setCellValue("学生姓名");
        cell2.setCellValue("学生性别");
        cell3.setCellValue("学生年龄");
        cell4.setCellValue("学生日期");
        //循环所有学生数据，将学生数据写入到一个个单元格中
        for (int i = 0; i < list.size(); i++) {
            StudentDemo studentDemo = list.get(i);
            //创建一个个的行对象
            XSSFRow row1 = sheet.createRow(i + 1);
            //创建每行的单元格对象
            XSSFCell dataCell0 = row1.createCell(0);
            dataCell0.setCellValue(studentDemo.getStudentId());

            XSSFCell dataCell1 = row1.createCell(1);
            dataCell1.setCellValue(studentDemo.getStudentName());

            XSSFCell dataCell2 = row1.createCell(2);
            dataCell2.setCellValue(studentDemo.getStudentSex());

            XSSFCell dataCell3 = row1.createCell(3);
            dataCell3.setCellValue(studentDemo.getStudentAge());

            //创建一个样式对象，转换日期格式
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            XSSFDataFormat dataFormat = workbook.createDataFormat();
            cellStyle.setDataFormat(dataFormat.getFormat("yyyy年MM月dd日 HH:mm:ss"));
            XSSFCell dataCell4 = row1.createCell(4);
            dataCell4.setCellValue(studentDemo.getStudentBirthday());
        }
        //上面循环结束，所有的单元格中，就有了所有数据，我们现在需要最后一步：将文档下载
        workbook.write(new FileOutputStream("C:\\Users\\admin\\Desktop\\天马七期值日表.xlsx"));
    }


}
