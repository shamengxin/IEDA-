package com.shamengxin.java.test;

public class NumberTest {
    public static void main(String[] args) {
        Number number=new Integer(5);
        //方法一：byte bytrValue()
        //以byte形式返回指定的数值
        byte b1=number.byteValue();
        System.out.println(b1);
        //方法二：abstract double doubleValue()
        //以double(浮点数）形式返回指定的数值
        double d1=number.doubleValue();
        System.out.println(d1);
        //方法三：abstract floatValue()
        //以float形式返回指定的数值
        float f1=number.floatValue();
        System.out.println(f1);
        //方法四：abstract int intValue()
        //以int形式返回指定的数值
        int i1=number.intValue();
        System.out.println(i1);
        //方法五：abstract long longValueS()
        //以long形式返回指定的数值
        long l1=number.longValue();
        System.out.println(l1);
        //方法六：short shortValue()
        //以short形式返回指定的数值
        short s1=number.shortValue();
        System.out.println(s1);


        //这些方法其实都是用来拆箱的，但现在有了自动拆箱和自动装箱，所以用处应该不大。
    }
}
