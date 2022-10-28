package com.shamengxin.java.Homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*5.有2个数组，第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，
        第二个数组为：[哈尔滨,杭州,南昌,广州,福州]，
        将第一个数组元素作为key，第二个数组元素作为value存储到Map集合中。
        如{黑龙江省=哈尔滨, 浙江省=杭州, …}*/
public class Homework05 {
    public static void main(String[] args) {
        String[] s1={"黑龙江省", "浙江省","江西省","广东省","福建省"};
        String[] s2={"哈尔滨","杭州","南昌","广州","福州"};
        Map<String,String> map=new HashMap<>();
        for (int i = 0; i <5 ; i++) {
            map.put(s1[i],s2[i]);
        }
        Set<String> keys=map.keySet();
        for(String key:keys){

            System.out.println(key+"="+map.get(key));
        }
    }
}
