package com.shemengxin.java.circularlinkedlist;

public class Boy {
    //结点编号
    private int no;
    //指向下一个结点
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
