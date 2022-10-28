package com.shamengxin.java.topic4;

import java.util.Scanner;

public class Topic4 {
    public static void main(String[] args) {
        System.out.println("大数据02-何雨峰-2062040222");
        int i,j,k,n,l,middle,temp;
        Scanner in=new Scanner(System.in);
        System.out.println("几阶？");
        n=in.nextInt();
        k = 1;
        temp = 0;
        middle = 0;
        for(i=1;i<=n;i++)
        {
            middle = i+1;
            k += temp;
            System.out.print(k+" ");
            l = k;
            for(j=n;j>0;j--)
            {
                if(j==1)
                    System.out.println();
                else
                {
                    l += middle;
                    if(i+j<=n+1)
                        System.out.print(l+" ");
                    middle++;
                }
            }
            temp++;
            middle--;
        }

    }
}
