package com.shamengxin.java.test;

public class IntegerTest {
    public static void main(String[] args) {
        //构造方法
        //注：现在有了自动装箱和拆箱，所以这些构造方法已经使用了
        //方法一：Integer(int)
        Integer integer1=new Integer(123);
        //方法二：Integer(String)
        Integer integer2=new Integer("123");

        //常用方法
        //方法一：static int parseInt(String s)
        //静态,将字符串转换为数字
        //实际应用：网页上文本输入的100实际上时“100”字符串，需要进行转化
        int i1=Integer.parseInt("100");
        System.out.println(i1);
        //方法二：static String toBinaryString(int i)
        //静态，将十进制转换成二进制字符串
        String s1=Integer.toBinaryString(123);
        System.out.println(s1);
        //方法三：static String toHexString(int i)
        //静态，将十进制转换成十六进制
        String s2=Integer.toHexString(123);
        System.out.println(s2);
        //方法四：static String toOctalString(int i)
        //静态，将十进制转换成八进制
        String s3=Integer.toOctalString(123);
        System.out.println(s3);
        //方法五：static Integer valueOf(int i)
        //静态,int-->Integer
        Integer i2=Integer.valueOf(123);
        System.out.println(i2);
        //方法六：static Integer valueOf(String s)
        //静态，String-->Integer
        Integer i3=Integer.valueOf("123");
        System.out.println(i3);

        //自动拆装箱实际上时自动的调用了valurOf方法
        //其他包装类的常用方法和以上相同。
    }
}
