package com.shamengxin.java.Stack;

import java.util.Arrays;

public class Stack<T> {
    private SqStack  s;

    //初始化栈
    public Stack(){
        s=new SqStack();
    }

    public Stack(int size){
        s=new SqStack(size);
    }

    //清空栈
    public boolean clear(){
        s.top=-1;
        return true;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        if(s.top==-1){
            return true;
        }else{
            return false;
        }
    }

    //返回栈中元素个数
    public int length(){
        return s.top+1;
    }

    //返回栈顶元素
    public Object getTop(){
        if(s.top==-1){
            return null;
        }else{
            return s.date[s.top];
        }
    }

    //入栈
    public boolean push(Object o){
        expansion();
        s.top++;
        s.date[s.top]=o;
        return true;
    }

    //出栈
    public Object pop(){
        if(s.top==-1){
            return null;
        }
        return s.date[s.top--];

    }

    //对集合中元素进行遍历输出
    public boolean traverse(){
        if(s.top==-1){
            System.out.println("栈为空！");
            return false;
        }else{
            int i=0;
            while(i<=s.top){
                System.out.print(s.date[i++]+" ");
            }
            System.out.println();
            return true;
        }

    }

    //对数组进行扩容，当容量达到80%时，进行扩容，扩容数组容量为原来的1.5倍
    private void expansion(){
        if((s.date.length-1)*4/5==s.top){
            int size=s.date.length*3/2;
            s.date= Arrays.copyOf(s.date,size);
        }
    }






}
