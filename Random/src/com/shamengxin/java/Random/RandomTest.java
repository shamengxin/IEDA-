/*编写程序，生成5个不重复的随机数[0-100]。重复的话重新生成。
        最终生成的5个随机数放到数组中，要求数组中这5个随机数不重复。*/
package com.shamengxin.java.Random;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random=new Random();
        int[] arr=new int[5];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=-1;
        }
        int index=0;
        while(index<arr.length){
            int num=random.nextInt(5);
            System.out.println("随机数："+num);
            if(!contains(arr,num)){
                arr[index++]=num;
            }
        }

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
    public static boolean contains(int[] arr,int num){
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==num)
                return true;
        }
        return false;
    }
}
