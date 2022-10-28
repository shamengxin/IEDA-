package com.shamengxin.java.ArrayAlgorithm;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={23,4,523,2,4,6,8,5,3,433,34};
        for (int i = 0; i <arr.length-1 ; i++) {
            int min=i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[min]>arr[j])
                    min=j;
            }
            if(min!=i){
                int tmp=arr[min];
                arr[min]=arr[i];
                arr[i]=tmp;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

