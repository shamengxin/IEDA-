package com.shamengxin.java.Homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*1、请使用序列化和反序列化机制，完成学生信息管理系统。

        系统打开时显示以下信息：
        欢迎使用学生信息管理系统，请认真阅读以下使用说明：
        请输入不同的功能编号来选择不同的功能：
        [1]查看学生列表
        [2]保存学生
        [3]删除学生
        [4]查看某个学生详细信息

        --------------------------------------------------------------------
        学生信息列表展示
        学号          姓名          性别
        ------------------------------------
        1               zhangsan        男
        2               lisi            女
        .....

        --------------------------------------------------------------------
        查看某个学生详细信息
        学号：1
        姓名：张三
        生日：1990-10-10
        性别：男
        邮箱：zhangsan@123.com

        ---------------------------------------------------------------------
        删除学生时，需要让用户继续输入删除的学生编号，根据编号删除学生。


        注意：请使用序列化和反序列化，以保证关闭之后，学生数据不丢失。
        学生数据要存储到文件中。*/
public class Homework {
    public static void main(String[] args) {
        Init();
        operate();
    }

    public static void Init(){
        ObjectOutputStream oos=null;
        try {
            Student student1=new Student(1,"小红","1990-08-21","女","1@qq.com");
            Student student2=new Student(2,"小橙","1997-06-18","男","2@qq.com");
            List<Student> studentList=new ArrayList<>();
            studentList.add(student1);
            studentList.add(student2);
            oos=new ObjectOutputStream(new FileOutputStream("Day32homework\\src\\com\\shamengxin\\java\\Homework\\Student"));
            oos.writeObject(studentList);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //菜单
    public static void meun(){
        System.out.println("欢迎使用学生信息管理系统，请认真阅读以下使用说明：");
        System.out.println("请输入不同功能编号实现不同的功能");
        System.out.println("【1】查看学生列表");
        System.out.println("【2】保存学生");
        System.out.println("【3】删除学生");
        System.out.println("【4】查看某个学生的详细信息");
        System.out.println("【0】退出");
    }
    //操作
    public static void operate(){
        while(true){
            meun();
            Scanner s = new Scanner(System.in);
            System.out.print("请选择功能编号：");
            int num = s.nextInt();
            switch (num){
                case 1:
                    StudentOperate.cheekAll();
                    System.out.println("========================");
                    break;
                case 2:
                    StudentOperate.save();
                    System.out.println("保存成功！");
                    System.out.println("========================");
                    break;
                case 3:
                    StudentOperate.delete();
                    System.out.println("删除成功！");
                    System.out.println("========================");
                    break;
                case 4:
                    StudentOperate.cheek();
                    System.out.println("========================");
                    break;
            }
            if(num==0){
                break;
            }
        }
    }

}
