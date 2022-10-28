package com.shamengxin.java.Homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentOperate {
    //查看学生列表
    public static void cheekAll(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Day32homework\\src\\com\\shamengxin\\java\\Homework\\Student"));
            ArrayList<Student> studentList=(ArrayList<Student>)ois.readObject();
            System.out.println("学号"+"\t"+"姓名"+"\t"+"性别");
            for(Student student:studentList){
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //保存学生
    public static void save(){
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois=new ObjectInputStream(new FileInputStream("Day32homework\\src\\com\\shamengxin\\java\\Homework\\Student"));
            ArrayList<Student> studentList=(ArrayList<Student>)ois.readObject();
            Scanner s=new Scanner(System.in);
            System.out.println("请输入学号：");
            int num=s.nextInt();
            System.out.println("请输入姓名：");
            String name=s.next();
            System.out.println("请输入生日：");
            String birth=s.next();
            System.out.println("请输入性别：");
            String sex=s.next();
            System.out.println("请输入邮箱：");
            String email=s.next();
            studentList.add(new Student(num,name,birth,sex,email));
            oos=new ObjectOutputStream(new FileOutputStream("Day32homework\\src\\com\\shamengxin\\java\\Homework\\Student"));
            oos.writeObject(studentList);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //删除学生
    public static void delete(){
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois=new ObjectInputStream(new FileInputStream("Day32homework\\src\\com\\shamengxin\\java\\Homework\\Student"));
            ArrayList<Student> studentList = (ArrayList<Student>) ois.readObject();
            Scanner s=new Scanner(System.in);
            System.out.print("请输入需要删除的学生序号：");
            int num=s.nextInt();
            for(int i=0;i<studentList.size();i++){
                if(studentList.get(i).getNo()==num){
                    studentList.remove(studentList.get(i));
                }
            }
            oos=new ObjectOutputStream(new FileOutputStream("Day32homework\\src\\com\\shamengxin\\java\\Homework\\Student"));
            oos.writeObject(studentList);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //查看某个学生信息
    public static void cheek(){
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream("Day32homework\\src\\com\\shamengxin\\java\\Homework\\Student"));
            ArrayList<Student> studentList = (ArrayList<Student>) ois.readObject();
            Scanner s=new Scanner(System.in);
            System.out.print("请输入需要查询的学生序号：");
            int num=s.nextInt();
            for(int i=0;i<studentList.size();i++){
                if(studentList.get(i).getNo()==num){
                    System.out.println("学号："+studentList.get(i).getNo());
                    System.out.println("姓名："+studentList.get(i).getName());
                    System.out.println("生日："+studentList.get(i).getBirth());
                    System.out.println("性别："+studentList.get(i).getSex());
                    System.out.println("邮箱："+studentList.get(i).getEmail());

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
