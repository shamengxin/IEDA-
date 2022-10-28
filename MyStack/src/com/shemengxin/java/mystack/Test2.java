package com.shemengxin.java.mystack;

/**
 * + - * / 的运算
 */
public class Test2 {
    public static void main(String[] args) {
        String str="4+33*2-1";
        ArrayStack numStack=new ArrayStack(10);
        ArrayStack symbolStack=new ArrayStack(10);

        /**
         * 获取字符串长度
         */
        int temp1=0;
        int temp2=0;
        int symbolChar=0;
        int result=0;
        int length=str.length();
        String values="";
        for(int i=0;i<length;i++){
            char c=str.charAt(i);
            //判断是否为运算符
            if(symbolStack.isOper(c)){
                //运算符栈是否为空
                if(!symbolStack.isEmpty()){
                    //比较优先级
                    if (symbolStack.priority(c)<=symbolStack.priority(symbolStack.peek())){
                        //从符号栈中取出一个元素，数字栈中取出两个元素，进行运算
                        temp1=numStack.pop();
                        temp2=numStack.pop();
                        symbolChar=symbolStack.pop();
                        result = numStack.calculate(temp1, temp2, symbolChar);

                        numStack.push(result);
                        symbolStack.push(c);
                    }else{
                        symbolStack.push(c);
                    }
                }else{
                    symbolStack.push(c);
                }
            }else{
                values+=c;
                if(i==length-1){
                    numStack.push(Integer.parseInt(values));
                }else{
                    char data = str.substring(i +1, i + 2).charAt(0);
                    if(symbolStack.isOper(data)){
                        numStack.push(Integer.parseInt(values));
                        values="";
                    }
                }
            }
        }
        while (true){
            if(symbolStack.isEmpty()){
                break;
            }
            temp1=numStack.pop();
            temp2=numStack.pop();
            symbolChar=symbolStack.pop();
            result=numStack.calculate(temp1,temp2,symbolChar);
            numStack.push(result);
        }

        System.out.println("结果是："+numStack.pop());
    }
}
