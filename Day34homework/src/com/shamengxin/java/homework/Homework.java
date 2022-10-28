package com.shamengxin.java.homework;

/*1、使用生产者和消费者模式实现，交替输出：
        假设只有两个线程，输出以下结果：
        t1-->1
        t2-->2
        t1-->3
        t2-->4
        t1-->5
        t2-->6
        ....

        要求：必须交替，并且t1线程负责输出奇数。t2线程负责输出偶数。
        两个线程共享一个数字，每个线程执行时都要对这个数字进行：++

public class Num {
    int i;
}

synchronized(num){
        if(num是奇数){
        num.wait();
        }
        // 输出偶数
        // notifyAll()
        }

synchronized(num){
        if(num是偶数){
        num.wait();
        }
        // 输出奇数
        // notifyAll();
        }*/
public class Homework {
    public static void main(String[] args) {
        Num num=new Num(1);
        Thread t1=new Thread(new OddThread(num));
        Thread t2=new Thread(new EvenThread(num));
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
