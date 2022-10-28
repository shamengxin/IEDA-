package com.shamengxin.java.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack();
        for (int i = 1; i <=10 ; i++) {
            s.push(i);
        }
        System.out.print("栈中元素依次为：");
        s.traverse();
        System.out.println("弹出的栈顶元素为："+s.pop());
        System.out.println("栈空否："+s.isEmpty());
        System.out.println("栈顶元素："+s.getTop());
        System.out.println("栈的长度为："+s.length());
        s.clear();
        System.out.println("清空栈后，栈空否："+s.isEmpty());
    }
}
