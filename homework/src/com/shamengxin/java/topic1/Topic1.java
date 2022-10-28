package com.shamengxin.java.topic1;

import java.util.Scanner;

public class Topic1 {
    public static void main(String[] args) {
        /*//循环
        BigDecimal x;
        BigDecimal a=new BigDecimal(0);
        BigDecimal sum=new BigDecimal(0);
        int number;
        Scanner in=new Scanner(System.in);
        System.out.print("请输入基数x：");
        x=in.nextBigDecimal();
        System.out.print("请输入项数number：");
        number=in.nextInt();
        for(int i=0;i<number;i++){
            a= a.multiply(BigDecimal.TEN).add(x);
            sum=sum.add(a);
        }
        System.out.println("结果sum："+sum);
        System.out.println("姓名：何雨峰 学号：2062040222  循环 实验一 ");*/

        //递归
        Scanner in = new Scanner(System.in);
        System.out.print("请输入N的个数：");
        int n = in.nextInt();
        int num = 0;
        int sum = 0;
        f(n, num, sum);
    }

    public static void f(int n,int num,int sum) {
        if (n > 0) {
            num = num * 10 + 2;
            sum = num + sum;
            n--;
            f(n, num, sum);
        } else {
            System.out.println(sum);
            System.out.println("姓名：何雨峰 学号：2062040222  递归 实验一 ");
        }
    }
}
