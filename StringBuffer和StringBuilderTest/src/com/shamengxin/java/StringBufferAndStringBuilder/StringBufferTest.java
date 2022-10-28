package com.shamengxin.java.StringBufferAndStringBuilder;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(3.14);
        stringBuffer.append("abc");
        stringBuffer.append(true);
        System.out.println(stringBuffer);
    }
}
//用于字符串拼接，是线程安全的