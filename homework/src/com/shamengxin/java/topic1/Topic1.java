package com.shamengxin.java.topic1;

import java.util.Scanner;

public class Topic1 {
    public static void main(String[] args) {
        /*//ѭ��
        BigDecimal x;
        BigDecimal a=new BigDecimal(0);
        BigDecimal sum=new BigDecimal(0);
        int number;
        Scanner in=new Scanner(System.in);
        System.out.print("���������x��");
        x=in.nextBigDecimal();
        System.out.print("����������number��");
        number=in.nextInt();
        for(int i=0;i<number;i++){
            a= a.multiply(BigDecimal.TEN).add(x);
            sum=sum.add(a);
        }
        System.out.println("���sum��"+sum);
        System.out.println("����������� ѧ�ţ�2062040222  ѭ�� ʵ��һ ");*/

        //�ݹ�
        Scanner in = new Scanner(System.in);
        System.out.print("������N�ĸ�����");
        int n = in.nextInt();
        int num = 0;
        int sum = 0;
        f(n, num, sum);
    }

    public static void f(int n,int num,int sum) {
        if (n > 0) {
            num = num * 10 + 2;
            sum = num + sum;
            n--;
            f(n, num, sum);
        } else {
            System.out.println(sum);
            System.out.println("����������� ѧ�ţ�2062040222  �ݹ� ʵ��һ ");
        }
    }
}
