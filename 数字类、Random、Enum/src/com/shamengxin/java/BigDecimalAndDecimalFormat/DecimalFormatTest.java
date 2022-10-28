package com.shamengxin.java.BigDecimalAndDecimalFormat;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args) {
        DecimalFormat df=new DecimalFormat("###,###.0000");
        //保留四位小数不够补0
        String s1=df.format(1234.56);
        System.out.println(s1);
    }
}
