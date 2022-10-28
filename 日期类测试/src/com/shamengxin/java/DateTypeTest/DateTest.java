package com.shamengxin.java.DateTypeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        //Date--->String
        Date nowTime=new Date();
        //System.out.println(nowTime);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String s1=sdf.format(nowTime);
        System.out.println(s1);
        //String--->Date
        String time="2022-08-10 22:11:32 666";
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        try {
            Date dateTime=sdf2.parse(time);
            System.out.println(sdf2.format(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //获取1970年1月1日 00:00:00 000 到当前系统时间的总毫秒数
        long nowTimeMillis=System.currentTimeMillis();
        //可以统计一个方法执行的耗时
        System.out.println(nowTimeMillis);
        Date nowTime1=new Date(nowTimeMillis);
        String s2=sdf2.format(nowTime1);
        System.out.println(s2);
        //获取昨日的当前时间
        Date time1=new Date(System.currentTimeMillis()-1000*60*60*24);
        String yesterdayNowTime=sdf2.format(time1);
        System.out.println(yesterdayNowTime);
    }
}
