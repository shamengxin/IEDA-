package com.shamengxin.java.homework;

public class OddThread implements Runnable{
    private  Num num;

    public OddThread(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while(true){
            synchronized (num){
                if(num.getI()%2==0){
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"--->"+num.getI());
                num.setI(num.getI()+1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num.notify();
            }
        }
    }
}
