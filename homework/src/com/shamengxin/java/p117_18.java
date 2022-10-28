package com.shamengxin.java;


public class p117_18 {
    public static void main(String[] args) {
        int i;
        for(i=5000;i<9999;i++)
            find(i);
        System.out.println("大数据02-何雨峰-2062040222");
    }

    public static void find(int i){
        int a[]=new int[10];
        int amount=0;
        int j,b,c;
        int flag=1;
        int count=0;
        for(j=0;j<10;j++)
            a[j]=count;
        b=2*i;
        c=b+i*100000;
        for(j=1;j<=9;j++)
        {
            count=c%10;
            c=c/10;
            a[count]=a[count]+1;
            if(a[count]>1)
                flag=0;
        }
        if(flag==1){
            System.out.printf("%6d%6d\n",i,b);
        }
    }
}
