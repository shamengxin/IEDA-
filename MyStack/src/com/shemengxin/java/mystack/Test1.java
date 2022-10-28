package com.shemengxin.java.mystack;

/**
 * 栈的应用：判断回文
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(detecation("hello"));
        System.out.println(detecation("aba"));
    }

    public static  boolean detecation(String val){
        /**
         * 初始化栈对象
         */
        ArrayStack arrayStack=new ArrayStack(10);

        /**
         * 获取字符串长度
         */
        int length=val.length();
        //把字符串进行压栈
        for(int i=0;i<length;i++){
            arrayStack.push(val.charAt(i));
        }

        /**
         * 取出栈中元素
         */
        String newVal="";
        //如果把arrayStack.length()放到for循环中，它并不是一个固定的值，会进行变化，
        //导致结果出现bug
        int length1=arrayStack.length();
        for(int i=0;i<length1;i++){
            //判断栈是否为空
            if(!arrayStack.isEmpty()){
                char pop=(char)arrayStack.pop();
                newVal=newVal+pop;
            }
        }

        if(val.equals(newVal)){
            return true;
        }else {
            return false;
        }
    }
}
