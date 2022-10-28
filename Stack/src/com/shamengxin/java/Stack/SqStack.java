package com.shamengxin.java.Stack;

class SqStack {
    Object[] date;
    int top =-1;

    public SqStack() {
        date=new Object[20];
    }

    public SqStack(int size) {
        date=new Object[size];
    }
}
