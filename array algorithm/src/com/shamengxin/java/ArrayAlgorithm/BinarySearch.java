package com.shamengxin.java.ArrayAlgorithm;

import java.util.function.ObjIntConsumer;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,3,6,7,8,10,35,68,85,94};
        BinarySearch binarySearch=new BinarySearch();
        int index=binarySearch.binarySearch(arr,35);
        System.out.println(index==-1?"该元素不存在！":"该元素下标为"+index);
    }
    public int binarySearch(int[] arr,int dest){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]<dest){
                left=mid+1;
            }else if(arr[mid]>dest){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
