package com.shamengxin.java.topic6;

import java.util.Scanner;

public class Topic6_2 {
    public static void main(String[] args) {
        System.out.println("请输入偶数：");
        int ROW,COL;
        Scanner in=new Scanner(System.in);
        ROW=in.nextInt();
        COL=ROW;
        int tmp = 1;
        int [][] arr=new int[ROW][COL];
        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                arr[i][j] = tmp++;
            }
        }
        int row1 = 1;
        int col1 = 1;

        int row2 = 1;
        int col2 = 1;

        for (int i = 0; i < (ROW / 4) ; i++)
        {
            for (int j = 0; j < (COL / 4); j++)
            {
                row1 = 4 * i;
                col1 = 4 * j;
                row2 = 4 * i;
                col2 = 4 * j + 3;
                for (int k = 0; k < 4; k++)
                {
                    arr[row1][col1] = (ROW * COL + 1) - arr[row1][col1];
                    arr[row2][col2] = (ROW * COL + 1) - arr[row2][col2];
                    row1++;
                    col1++;
                    row2++;
                    col2--;
                }
            }
        }

        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                System.out.printf("%-3d", arr[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.println("大数据02-何雨峰-2062040222");
    }
}
