package com.shamengxin.java.StringClassMethodTest;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //构造方法
        //第一个：最常用
        String s1="abc";
        //第二个：
        String s2=new String("abc");
        //第三个：
        char[] arr1={'a','b','c'};
        String s3=new String(arr1);
        //第四个：
        char[] arr2={'a','b','c','d','e'};
        String s4=new String(arr2,0,5);
        //第五个：
        byte[] arr3={97,98,99};
        String s5=new String(arr3);
        //第六个：
        byte[] arr4={97,98,99,100,101,102};
        String s6=new String(arr4,0,6);
       //注：byte数组的打印需要用到Arrays.toString(byte[] b1)方法、
        //byte[] arr4={1,2,3,4,5,6};
        //System.out.println(s6);结果：
        //原因：因为byte数组转化为String会根据byte数组里面的数字的ASCII码值转化成对应字符，
        //但因为byte数组里面的值为1，2，3，4，5，6对应的字符是一些表情，无法打印所以是这样。

        //常用方法
        //第一个：char charAt(int index)
        // 获取字符串中下标为index的字符
        char c1=s1.charAt(1);
        System.out.println(c1);
        //第二个：int compareTo(String antherString)
        //比较两字符串的大小，相等返回0，小于返回负数，大于返回正数
        int i1=s1.compareTo(s2);
        System.out.println(i1);
        //第三个：boolean contains(CharSequence s)
        //判断前面的字符串中是否包含后面的子字符串
        boolean b1=s4.contains("bcd");
        System.out.println(b1);
        //第四个：boolean endsWith(String suffix)
        //判断当前字符串是否以某个字符串结尾
        boolean b2=s4.endsWith("de");
        System.out.println(b2);
        //第五个：boolean equals(Object anObject)
        //判断两个字符串是否相等
        boolean b3=s4.equals(s3);
        System.out.println(b3);
        //第六个：boolean equalsIgnoreCase(String antherString)
        //忽略大小写判断字符串是否相等
        String s7="ABC";
        boolean b4=s7.equalsIgnoreCase(s1);
        System.out.println(b4);
        //第七个：byte[] getBytes()
        //将字符串转换为字节数组
        byte[] arr5=s3.getBytes();
        System.out.println(Arrays.toString(arr5));
        //第八个：int indexOf(String str)
        //返回某个子字符串在当前字符串中第一次出现的下标
        int i2=s6.indexOf("de");
        System.out.println(i2);
        //第九个：boolean isEmpty()
        //判断某个字符串是否为空
        boolean b5=s3.isEmpty();
        System.out.println(b5);
        //第十个：int length()
        //返回此字符串的长度
        int i3=s6.length();
        System.out.println(i3);
        //第十一个：int lastIndexOf(String str)
        //返回某个子字符串在当前字符串中最后一次出现处的下标
        String s8="abcdabdes";
        int i4=s8.lastIndexOf("ab");
        System.out.println(i4);
        //第十二个：String replace(CharSequence target,CharSequence replacement)
        //将target串替换成replacement
        String s9=s8.replace("ab","cd");
        System.out.println(s9);
        //第十三个：String[] split(String regex)
        //按某个字符串regex对使用它的那个字符串进行拆分
        String s10="ab-cd-ef";
        String[] s11=s10.split("-");
        for (int i = 0; i <s11.length ; i++) {
            System.out.print(s11[i]+" ");
        }
        System.out.println();
        //第十四个：boolean startsWith(String prefix)
        //判断某个字符串是否以某个子字符串开始
        boolean b6=s4.startsWith("ab");
        System.out.println(b6);
        //第十五个：String substring(int beginIndex)
        //从beginIndex下标处截取字符串
        String s12=s4.substring(3);
        System.out.println(s12);
        //第十六个：String substring(int beginIndex,int endIndex)
        //beginIndex起始位置（包括）
        //endIndex结束位置（不包括）
        String s13=s4.substring(2,5);
        System.out.println(s13);
        //第十七个：char[] toCharArray()
        //将字符串转换成char数组
        char[] c2=s4.toCharArray();
        for (int i = 0; i <c2.length ; i++) {
            System.out.print(c2[i]);
        }
        System.out.println();
        //第十八个：String toLowerCase
        //转换成小写
        String s14="ABCDEF";
        String s15=s14.toLowerCase();
        System.out.println(s15);
        //第十九个：String toUpperCase()
        //转换成大写
        String s16=s4.toUpperCase();
        System.out.println(s16);
        //第二十个：String trim()
        //去除字符串前后空白
        String s17="   cdefgh   ";
        String s18=s17.trim();
        System.out.println(s18);
        //第二十一个：valueOf()
        //String中只有一个方法是静态的，不需要new对象
        //作用：将“非字符串”转换为“字符串”
        int[] i5={1,2,3,4,5,6,7};
        String s19=String.valueOf(i5);
        System.out.println(s19);
    }
}
