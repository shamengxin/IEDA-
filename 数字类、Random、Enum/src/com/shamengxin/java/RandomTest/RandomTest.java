package com.shamengxin.java.RandomTest;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random=new Random();
        int num1=random.nextInt();
        System.out.println(num1);
        //指定区间1～100
        int num2=random.nextInt(101);
        System.out.println(num2);
    }
}
