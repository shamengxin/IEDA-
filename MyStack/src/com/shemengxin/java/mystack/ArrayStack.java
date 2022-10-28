package com.shemengxin.java.mystack;

/**
 * 栈
 */
public class ArrayStack {
    /**
     * 栈的大小
     */
    private int maxStack;

    /**
     * 用数组来模拟栈
     */
    private int[] stack;

    /**
     * 使用top指向栈顶位置，默认为-1
     */
    private int top=-1;

    public ArrayStack(int maxStack){
        this.maxStack=maxStack;
        stack=new int[maxStack];
    }

    /**
     * 判断是否已经满栈
     */
    public boolean isFull(){
        return this.top==this.maxStack-1;
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty(){
        return this.top==-1;
    }

    /**
     * 压栈
     */
    public void push(int val){
        //判断是否栈满
        if(isFull()){
            throw new RuntimeException("此栈已满");
        }
        stack[++top]=val;
    }

    /**
     * 弹栈
     */
    public int pop(){
        //判断栈是否为空
        if(isEmpty()){
            throw new RuntimeException("空栈，未找到数据");
        }
        return stack[top--];
    }

    /**
     * 查看栈中所有元素
     */
    public void list(){
        //判断栈是否为空
        if(isEmpty()){
            throw new RuntimeException("栈空，未找到数据");
        }
        for (int i = 0; i <stack.length ; i++) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    /**
     * 栈中元素个数
     * @return
     */
    public int length(){
        return this.top+1;
    }

    /**
     * 判断是否是一个运算符+ - * /
     */
    public boolean isOper(char v){
        return v=='+'||v=='-'||v=='*'||v=='/';
    }

    /**
     * 判断运算符的优先级，使用数字表示优先级大小，数字越大的优先级越大
     */
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;
        }

    }

    /**
     * 获取栈顶元素
     */
    public int peek(){
        return this.stack[top];
    }

    /**
     * 获取栈的容量
     */
    public int stackLength(){
        return this.stack.length;
    }

    /**
     * 计算两个数进行运算后的结果
     */
    public int calculate(int num1,int num2,int oper){
        //计算结果
        int result=0;
        switch (oper){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num2-num1;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num2/num1;
                break;
            default:
                break;
        }
        return result;
    }
}
