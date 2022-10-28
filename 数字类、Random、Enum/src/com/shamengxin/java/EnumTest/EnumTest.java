package com.shamengxin.java.EnumTest;

public class EnumTest {
    public static void main(String[] args) {
        switch(Season.WINTER){
            case SPRING :
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
}

enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}