package com.shemengxin.java.doublylinked;

/**
 * 双向链表测试
 */
public class LinkedTest {
    public static void main(String[] args) {
        DualLinkedList dualLinkedList=new DualLinkedList();

        BookNode bookNode1=new BookNode(1,"红楼梦",55.00);
        BookNode bookNode2=new BookNode(2,"三国演义",55.00);
        BookNode bookNode3=new BookNode(3,"西游记",55.00);
        BookNode bookNode4=new BookNode(4,"水浒传",55.00);

        dualLinkedList.addLast(bookNode1);
        dualLinkedList.addLast(bookNode2);
        dualLinkedList.addLast(bookNode3);
        dualLinkedList.addLast(bookNode4);

        //dualLinkedList.delNode(1);
        //dualLinkedList.updateNode(new BookNode(3,"计算机",66.00));
        System.out.println();
    }
}
