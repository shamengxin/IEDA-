package com.shamengxin.java.homeworkamend;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Operate {
    //查看学生列表
    public static void cheekAll(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Day32homeworkAmend\\src\\com\\shamengxin\\java\\homeworkamend\\Student"));
            Map<Integer,Student> map=(Map<Integer,Student>)ois.readObject();
            Set<Integer> set=map.keySet();
            System.out.println("学号"+"\t"+"姓名"+"\t"+"性别");
            System.out.println("---------------------");
            for(Integer student:set){
                System.out.println(map.get(student));
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
            ois=new ObjectInputStream(new FileInputStream("Day32homeworkAmend\\src\\com\\shamengxin\\java\\homeworkamend\\Student"));
            Map<Integer,Student> map=(Map<Integer,Student>)ois.readObject();
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
            if(map.containsKey(num)){
                System.out.println("该序号已存在，保存失败");
            }else {
                map.put(num, new Student(num, name, birth, sex, email));
                oos = new ObjectOutputStream(new FileOutputStream("Day32homeworkAmend\\src\\com\\shamengxin\\java\\homeworkamend\\Student"));
                oos.writeObject(map);
                oos.flush();
                System.out.println("保存成功！");
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
            ois=new ObjectInputStream(new FileInputStream("Day32homeworkAmend\\src\\com\\shamengxin\\java\\homeworkamend\\Student"));
            Map<Integer,Student> map=(Map<Integer,Student>)ois.readObject();
            Scanner s=new Scanner(System.in);
            System.out.print("请输入需要删除的学生序号：");
            int num=s.nextInt();
            if(map.containsKey(num)) {
                map.remove(num);
                oos = new ObjectOutputStream(new FileOutputStream("Day32homeworkAmend\\src\\com\\shamengxin\\java\\homeworkamend\\Student"));
                oos.writeObject(map);
                oos.flush();
                System.out.println("删除成功！");
            }else {
                System.out.println("该序号不存在，操作失败！");
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
            ois=new ObjectInputStream(new FileInputStream("Day32homeworkAmend\\src\\com\\shamengxin\\java\\homeworkamend\\Student"));
            Map<Integer,Student> map=(Map<Integer,Student>)ois.readObject();
            Scanner s=new Scanner(System.in);
            System.out.print("请输入需要查询的学生序号：");
            int num=s.nextInt();
            if(map.containsKey(num)){
                Student studentList=map.get(num);
                System.out.println("学号："+studentList.getNo());
                System.out.println("姓名："+studentList.getName());
                System.out.println("生日："+studentList.getBirth());
                System.out.println("性别："+studentList.getSex());
                System.out.println("邮箱："+studentList.getEmail());
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
