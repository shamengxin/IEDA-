package com.shamengxin.java.StringBufferAndStringBuilder;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("3.14");
        stringBuilder.append(123);
        stringBuilder.append(true);
        System.out.println(stringBuilder);
    }
}

//非线程安全的，用于字符串拼接