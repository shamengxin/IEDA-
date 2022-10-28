package com.shemengxin.java.linked;

/**
 * 创建结点
 */
public class GoodsNode {
    public int id;
    public String name;
    public double price;
    public GoodsNode next;

    public GoodsNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodsNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
