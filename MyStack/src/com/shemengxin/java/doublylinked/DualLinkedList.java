package com.shemengxin.java.doublylinked;

public class DualLinkedList {
    private  BookNode head =new BookNode(0,"",0.0);

    /**
     * 添加结尾新的结点
     */
    public void addLast(BookNode newNode){
        BookNode temp=head;
        while (true){
            //如果第一次就进入，则表示双向链表是空数据
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        /**
         * 需要把新的节点给上一个节点
         * 需要把上一个结点next指向新的结点
         */
        temp.next=newNode;
        newNode.pre=temp;
    }

    /**
     * 修改节点
     * 条件：双向链表中的每一个节点的和修改的id对比，如果对比成功，则对此节点进行修改，
     * 如果未对比成功，双向链表未找到目标节点
     */
    public void updateNode(BookNode node){
        //是否是空链表
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }
        BookNode temp=head.next;
        boolean flg=false;
        while (true){
            if(temp==null){
                break;
            }
            if(temp.id==node.id) {
                flg = true;
                break;
            }
            temp=temp.next;
        }
        if(flg){
            temp.name=node.name;
            temp.price=node.price;
        }else{
            System.out.println("未找到更改目标！");
        }
    }

    /**
     * 双向链表的删除
     * 条件：根据id编号进行节点删除
     */
    public void delNode(int id){
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }
        BookNode temp=head.next;
        boolean flg=false;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.id==id){
                flg=true;
                break;
            }
            temp=temp.next;
        }
        if(flg){
            temp.pre.next=temp.next;
            //注意：要判断后一个节点是否为空
            if(temp.next!=null) {
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("未找到删除目标！");
        }
    }
}
