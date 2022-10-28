package com.shamengxin.java.ArrayAlgorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={3,4,6,25,6,85,43,2,5,6};
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
