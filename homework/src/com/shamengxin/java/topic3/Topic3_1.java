package com.shamengxin.java.topic3;

import java.util.Scanner;

public class Topic3_1 {
    public static void main(String[] args) {
        System.out.println("大数据02-何雨峰-2062040222");
        int length;
        do
        {
            System.out.println("请输入回旋数组长度（大于零的整数）：");
            Scanner scanner = new Scanner(System.in);
            length = scanner.nextInt();
        }while (length < 1);


        int[][] array = new int[length][length];

        int row = 0;
        int column = -1;

        int val01 = length - 1;
        int val02 = 0;

        int endVal = length * length;

        for (int i = 1; i < endVal; row = ++val02, val01--)
        {
            while (column < val01)
            {
                array[row][++column] = i++;
            }
            while (row < val01)
            {
                array[++row][column] = i++;
            }
            while (column > val02)
            {
                array[row][--column] = i++;
            }
            while (row > val02 + 1)
            {
                array[--row][column] = i++;
            }
        }

        if (endVal % 2 != 0 && endVal / 2 > 0)
        {
            array[row][++column] = endVal;
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
