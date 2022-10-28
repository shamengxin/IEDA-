package com.shamengxin.java;

public class topic12 {

    public static void main(String[] args) {
        boolean[] arr = new boolean[52];
        int count=0;
        for(int start = 1, skip = 1; start < arr.length; start ++, skip ++){
            int i = start;
            while(i < arr.length){
                arr[i] = !arr[i];
                count++;
                i += skip + 1;
                if(count==140){
                    break;
                }
            }
        }

        int sum=0;
        for(int i = 0; i < arr.length; i ++){
            if(! arr[i]) {
                System.out.print(i+1+" ");
                sum++;
            }
        }
        System.out.println();
        System.out.println("正面朝上的总数为："+sum);
        System.out.println("大数据02-何雨峰-2062040222");
    }
}
