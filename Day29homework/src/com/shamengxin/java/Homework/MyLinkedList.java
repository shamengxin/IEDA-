package com.shamengxin.java.Homework;

public class MyLinkedList {
    Node header;
    int size=0;

    //添加数据的方法
    public void add(Object data){
        if(size==0){
            header=new Node(data,null);
        }else{
            findLast(header).next=new Node(data,null);
        }
        size++;
    }
    //寻找最后一个节点
    private Node findLast(Node header) {
        if(header.next==null){
            return header;
        }
        return findLast(header.next);
    }
    //删除节点
    public void delete(Object data){
        Node node=header;
        Node prenode=node;
        int flag=0;
        while(node!=null){
            if(data.equals(node.data)){
                prenode.next=node.next;
                System.out.println(data+"已删除");
                flag=1;
            }
            prenode=node;
            node=node.next;
        }
        if(flag==0){
            System.out.println("无此元素，删除失败");
        }
    }
    //修改元素
    private void changeDate(Object data,Object now){
        if(find(data)==null){
            System.out.println("无此元素");
            return;
        }
        find(data).data=now;
        System.out.println("修改成功");
    }
    //查找元素
    public Node find(Object data){
        Node node=header;
        while(node!=null){
            if(data.equals(node.data)){
                return node;
            }
             node=node.next;
        }
        return null;
    }
    //打印数据
    public void print(){
        Node node=header;
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }
}
