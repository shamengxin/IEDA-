package com.shamengxin.java.homework;

public class Tickets implements SaleTicket {
    int num;
    Ticket[] tickets;
    int saleId=1;

    public Tickets() {
    }

    public Tickets(int num) {
        this.num = num;
        tickets=new Ticket[num];
    }

    public synchronized void saleTicket() throws SaleOfTicketsException {
        if(saleId<=num){
            System.out.println(Thread.currentThread().getName()+"卖出Id为"+saleId+"的票");
            tickets[saleId-1]=null;
            saleId++;
        }
        if(saleId>num){
            throw new SaleOfTicketsException(Thread.currentThread().getName()+"票已经买完了");
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
