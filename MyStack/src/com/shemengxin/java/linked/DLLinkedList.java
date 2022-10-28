package com.shemengxin.java.linked;

/**
 * 单向链表实现
 */
public class DLLinkedList {
    //头节点
    private GoodsNode node=new GoodsNode(0,"",0.0);

    /**
     * 向链表中添加结点
     * @param goodsNode
     */
    public void add(GoodsNode goodsNode){
        GoodsNode temp=node;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=goodsNode;
    }

    /**
     * 按照id的大小进行插入，并且id不能重复
     * @param goodsNode
     */
    public void addOrder(GoodsNode goodsNode){
        GoodsNode temp=node;
        boolean flg=false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.id>goodsNode.id){
                break;
            }else if(temp.next.id==goodsNode.id){
                //这个判断是防止商品重复的
                flg=true;
                break;
            }
            temp=temp.next;
        }

        if(flg){
            System.out.println("该商品已存在,不能重复添加元素。");
        }else{
            goodsNode.next=temp.next;
            temp.next=goodsNode;
        }
    }

    /**
     * 对链表结点的修改
     * @param goodsNode
     */
    public void updateNode(GoodsNode goodsNode){
        //判断链表是否为空
        if(node.next==null){
            System.out.println("链表为空。");
            return;
        }

        GoodsNode temp=node.next;
        //用于定义是否找到了结点
        boolean flg=false;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.id==goodsNode.id){
                flg=true;
                break;
            }

            temp=temp.next;
        }

        if(flg){
            temp.name=goodsNode.name;
            temp.price=goodsNode.price;
        }else{
            System.out.println("在整个链表中未找到目标结点。");
        }

    }

    /**
     * id具有唯一性，根据id进行删除结点
     * @param id
     */
    public void delNode(int id){
        GoodsNode temp=node;
        boolean flg=false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.id==id){
                flg=true;
                break;
            }
            temp=temp.next;
        }
        if(flg){
            temp.next=temp.next.next;
        }else{
            System.out.println("此id不存在。");
        }
    }

    /**
     * 检索整个链表
     */
    public void list(){
        if(node.next==null){
            System.out.println("此链表为空");
            return;
        }
        GoodsNode temp=node.next;
        while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    /**
     * 面试题
     * 计算单链表中存在的结点个数
     * 不统计头节点
     */
    public int getLength(){
        if(node.next==null){
            System.out.println("空链表");
            return 0;
        }
        GoodsNode temp=node.next;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

}
