package com.shamengxin.java.homeworkamend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
/**
 * Day32homework问题描述：
 *      数据无法保存，每次重启程序后数据都会刷新，变成初始化的值。
 * 原因：在程序的最开始有一个初始化，初始化的数据在写入Student文档时，是会先将文档内容清空然后再写入，
 *       所以导致每次重启程序后，数据都是初识话内容。
 * 解决：修改初始化方法：
 *          1.让初识化方法只执行一次，除了初次启动程序时执行，以后启动程序都不在执行，但以现
 *            在所学还不知道如何去做。
 *          2.让初始化的元素以追加的方式添加，但这样就会造成每次启动程序就会多几个初始化元素，
 *            所以要让除第一次外，后面追加的元素无效，刚好Map集合符合这个需求，所以将取出和存
 *            入的元素改为Map集合，然后在初始化方法中，将数据的添加改为以追加啊的方式即可。
 */

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
            Map<Integer,Student> map=new HashMap<>();
            map.put(student1.getNo(),student1);
            map.put(student2.getNo(),student2);
            oos=new ObjectOutputStream(new FileOutputStream("Day32homeworkAmend\\src\\com\\shamengxin\\java\\homeworkamend\\Student",true));
            oos.writeObject(map);
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
        meun();
        while(true){
            Scanner s = new Scanner(System.in);
            System.out.print("请选择功能编号：");
            int num = s.nextInt();
            switch (num){
                case 1:
                    Operate.cheekAll();
                    System.out.println("========================");
                    break;
                case 2:
                    Operate.save();
                    System.out.println("========================");
                    break;
                case 3:
                    Operate.delete();
                    System.out.println("========================");
                    break;
                case 4:
                    Operate.cheek();
                    System.out.println("========================");
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
