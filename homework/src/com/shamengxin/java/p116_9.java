package com.shamengxin.java;

public class p116_9 {
    public static void main(String[] args) {
        System.out.printf("beehouse(1, 2)= %d\n", beehouse(1, 2));
        System.out.printf("beehouse(1, 3)= %d\n", beehouse(1, 3));
        System.out.printf("beehouse(1, 4)= %d\n", beehouse(1, 4));
        System.out.printf("beehouse(1, 5)= %d\n", beehouse(1, 5));
        System.out.printf("beehouse(1, 6)= %d\n", beehouse(1, 6));
        System.out.printf("beehouse(7, 13) =%d\n", beehouse(7, 13));
        System.out.printf("beehouse(9, 14) = %d\n", beehouse(9, 14));
        System.out.println("大数据02-何雨峰-2062040222");
    }
    public static int beehouse(int a, int b)
    {
        if (a+1==b)
            return 1;
        else if (a+2==b)
            return 2;
        else
            return beehouse(a, b-1)+beehouse(a, b-2);
    }
}
