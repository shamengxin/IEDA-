package com.shamengxin.java.topic6;

import java.util.Scanner;

public class Topic6_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入奇数构造魔方:");
        int p = input.nextInt();
        if (p % 2 == 0)
            System.out.println("请输入奇数");
        else {
            int n = p;
            int[][] a = new int[n][n];
            int hang, lei;
            hang = 0;
            lei = n / 2;
            for (int i = 1; i <= n * n; i++) {
                a[hang][lei] = i;
                hang--;
                lei++;
                if (hang < 0 && lei >= n) {
                    hang = hang + 2;
                    lei--;
                }
                if (hang < 0)
                    hang = n - 1;
                if (lei >= n)
                    lei = 0;
                if (a[hang][lei] != 0) {
                    hang = hang + 2;
                    lei--;
                }
            }
            for (int[] i : a) {
                for (int j : i) {
                    System.out.print(j + "\t");
                }
                System.out.println();
            }
        }
        System.out.println("大数据02-何雨峰-2062040222");
    }
}
