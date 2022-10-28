package com.shamengxin.java.Homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*6.定义一个泛型为String类型的List集合，统计该集合中每个字符
        （注意，不是字符串）出现的次数。例如：集合中有”abc”、”bcd”两个元素，
        程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。*/
public class Homework06 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        list.add("abc");
        list.add("bcd");
        for(String s:list){
            char[] c1=s.toCharArray();
            for(char c2:c1){
                if(!map.containsKey(c2)){
                    map.put(c2,1);
                }else{
                    map.put(c2,map.get(c2)+1);
                }
            }
        }
        System.out.println(map);
    }
}
