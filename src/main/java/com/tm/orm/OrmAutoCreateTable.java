package com.tm.orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OrmAutoCreateTable {

    public static void main(String[] args) throws Exception {
        //第一步，先获取到类
        Class studentClass = Student.class;
        //获取当前类上的表名注解
        TmTableName tableName = (TmTableName) studentClass.getDeclaredAnnotation(TmTableName.class);
        //通过这个注解获取到注解对应的value，也就是表名
        String tableNameStr = tableName.value();
        //获取当前类中的所有属性,不能直接使用类对象来获取属性上的注解
        //换句话说，注解写在哪里，就得用谁来获取这个注解。
        Field[] fields = studentClass.getDeclaredFields();

        //写建表语句
        /*

            create table t_student7(
                student_id int(11),
                student_name varchar(255),
                student_sex varchar(255),
                student_age int(11)
            )
        * */
        StringBuffer createTableSql = new StringBuffer("create table ");
        createTableSql.append(tableNameStr);
        createTableSql.append("(");
        //循环所有属性，获取到每个属性对应的注解
        for (Field field : fields) {
            TmTableId tableId = field.getDeclaredAnnotation(TmTableId.class);
            //获取每个属性上的字段注解
            TmPropertyName propertyName = field.getDeclaredAnnotation(TmPropertyName.class);
            //获取到字段名
            String propertyNameStr = propertyName.value();
            createTableSql.append(propertyNameStr);
            //按理来说，在拼接数据类型时，需要做完整的判断
            //这里嫌麻烦先不写了，自己写的时候可以做完整判断
            Class type = field.getType();


            //如果是主键则需要特殊操作
            if(null != tableId){
                //在这里判断java中的数据类型，根据不同的数据类型在sql中拼接不同的数据类型
                if(Integer.class.isAssignableFrom(type)){
                    createTableSql.append(" ");
                    createTableSql.append("int(11) primary key AUTO_INCREMENT,");
                }
                if(String.class.isAssignableFrom(type)){
                    createTableSql.append(" ");
                    createTableSql.append("varchar(255) primary key,");
                }
            }else{
                //否则不是主键，是其他字段
                //在这里判断java中的数据类型，根据不同的数据类型在sql中拼接不同的数据类型
                if(Integer.class.isAssignableFrom(type)){
                    createTableSql.append(" ");
                    createTableSql.append("int(11),");
                }
                if(String.class.isAssignableFrom(type)){
                    createTableSql.append(" ");
                    createTableSql.append("varchar(255),");
                }
            }

        }
        //循环结束后，将最后一位逗号干掉，再拼一个最外层的括号，sql语句就完成了
        String substring = createTableSql.substring(0, createTableSql.length() - 1);
        substring = substring + ")";
        //在这里进行jdbc操作将sql执行
        String url = "jdbc:mysql://localhost:3306/tm?serverTimezone=Asia/Shanghai";
        Connection con;
        Statement statement;
        int i;
        String string;
        try {
             Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序,如果你的mysqlconnection依赖版本是在8.0以上，则需要使用cj
             con = DriverManager.getConnection(url, "root", "root"); //建立与数据库的连接，后两个参数分别为账号和密码
             statement = con.createStatement(); //创建Statement对象
             statement.executeUpdate(substring);//执行sql查询语句，返回结果集

            statement.close(); //关闭Statement对象
            con.close(); //关闭与数据库的连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
