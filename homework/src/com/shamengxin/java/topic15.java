package com.shamengxin.java;

public class topic15 {
    public static void main(String[] args) {

        char i, j, k;
        for (i = 'x'; i <= 'z'; i++) {
            for (j = 'x'; j <= 'z'; j++) {
                if (i != j) {
                    for (k = 'x'; k <= 'z'; k++) {
                        if (i != k && j != k) {
                            if (i != 'x' && k != 'x' && k != 'z') {
                                System.out.println("A--" + i + "\n" + "B--" + j + "\n" + "C--" + k);
                                System.out.println("大数据02-何雨峰-2062040222");
                            }
                        }
                    }
                }
            }
        }
    }
}


