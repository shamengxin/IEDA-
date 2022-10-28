package com.shemengxin.java.circularlinkedlist;

public class CircleSingleLinkedList {

    private Boy first=new Boy(-1);

    /**
     * 构建环形链表
     */
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("数据有误！");
            return;
        }

        Boy temp=null;
        for(int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            /**
             * 判断是否为第一个小孩
             */
            if(i==1){
                first=boy;
                first.setNext(first);
                temp=first;
            }else{
                temp.setNext(boy);
                boy.setNext(first);
                temp=boy;
            }
        }
    }
}
