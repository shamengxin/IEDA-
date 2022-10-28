package com.shemengxin.java.doublylinked;

public class BookNode {
    public int id;
    public String name;
    public double price;

    //Ç°Çý
    public BookNode pre;
    //ºó¼Ì
    public BookNode next;

    public BookNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
