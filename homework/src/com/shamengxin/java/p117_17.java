package com.shamengxin.java;

import java.util.Scanner;

public class p117_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, c, i,sum = 0;
        System.out.printf("Please think of a number between 1 and 100.\n");
        System.out.printf("your number divided by 3 has a reminder of:");
        a = in.nextInt();
        System.out.printf("Your number divided by 4 has a reminder of:");
        b = in.nextInt();
        System.out.printf("Your number divided by 7 has a reminder of:");
        c = in.nextInt();
        System.out.printf("Let think a moment,emmm--\n");
        int flag = 0;
        for (i=1; i <= 100; i++)
        {
            if (i % 3 == a && i % 4 ==b && i % 7 ==c)
            {
                System.out.printf("Oh,your number was %d\n", i);
                flag = 1;
            }
            else
            {
                flag = 0;
            }
            sum += flag;
        }
        if (sum == 0)
        {
            System.out.printf("no solution");
        }
        System.out.println("大数据02-何雨峰-2062040222");
    }
}
