package com.shamengxin.java.topic5;

public class Topic5 {
    public static void main(String[] args) {
        int x=0,y=0,i,j;
        for(i=1;i<=2*3;i++) {
            for (j = 1; j <= 2 * 3; j++) {
                if (i > 3) x = 2 * 3 - i + 1;
                else x = i;
                if (j > 3) y = 2 * 3 - j + 1;
                else y = j;
                System.out.printf("%-2d", x <= y ? x : y);
            }
            System.out.println();
        }
        System.out.println("大数据02-何雨峰-2062040222");
    }
}
