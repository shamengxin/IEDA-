package com.shamengxin.java.topic2;

import java.util.Scanner;

public class Topic2 {
    public static void main(String[] args) {
        int[] a=new int[6];
        Scanner in=new Scanner(System.in);
        while(true){
            for (int i = 0; i <6 ; i++) {
                System.out.print("请输入No."+(i+1)+":");
                a[i]=in.nextInt();
            }
            for (int i = 0; i <6 ; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(a[j] + " ");
                }
                System.out.println();
                int temp=a[5];
                for (int j = 5; j >=0 ; j--) {
                    if(j!=0){
                        a[j]=a[j-1];
                    }else{
                        a[j]=temp;
                    }
                }
            }
            break;
        }
        System.out.println("姓名：何雨峰 学号：2062040222 实验二 ");
    }
}
