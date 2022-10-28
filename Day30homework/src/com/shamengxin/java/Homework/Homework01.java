package com.shamengxin.java.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//1.产生10个1-100的随机数，并放到一个数组中，把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
public class Homework01 {
    public static void main(String[] args) {
        Random random=new Random();
        int[] arr = new int[10];
        for (int i = 0; i <10 ; i++) {
            arr[i]=random.nextInt(101);
        }
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<10;i++) {
            if(arr[i]>=10){
                list.add(arr[i]);
            }
        }
        System.out.print("大于等于10的数字：");
        for (int list1:list) {
            System.out.print(list1+" ");
        }

    }
}
