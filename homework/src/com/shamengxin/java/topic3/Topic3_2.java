package com.shamengxin.java.topic3;

import java.util.Scanner;

public class Topic3_2 {
    public static void main(String[] args) {
        System.out.println("大数据02-何雨峰-2062040222");
        int length;
        do
        {
            System.out.println("请输入回旋数组长度（大于零的整数）：");
            Scanner scanner = new Scanner(System.in);
            length = scanner.nextInt();
        } while (length < 1);


        int[][] array = new int[length][length];

        int row = 0;
        int column = -1;

        int val01 = length;
        int val02 = length - 1;
        int val03 = length - 1;
        int val04 = length - 2;

        int endVal = length * length;

        for (int i = 1, times = 0; i <= endVal; val01 -= 2, val02 -= 2, val03 -= 2, val04 -= 2)
        {
            while (times++ < val01)
            {
                array[row][++column] = i++;
            }
            times = 0;

            while (times++ < val02)
            {
                array[++row][column] = i++;
            }
            times = 0;

            while (times++ < val03)
            {
                array[row][--column] = i++;
            }
            times = 0;

            while (times++ < val04)
            {
                array[--row][column] = i++;
            }
            times = 0;
        }

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
