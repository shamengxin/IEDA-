package com.shamengxin.java.BigDecimalAndDecimalFormat;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal b1=new BigDecimal(24);
        BigDecimal b2=new BigDecimal(12);
        BigDecimal b3=b1.add(b2);
        System.out.println(b3);
        BigDecimal b4=b1.multiply(b2);
        System.out.println(b4);
        BigDecimal b5=b1.divide(b2);
        System.out.println(b5);


    }
}
