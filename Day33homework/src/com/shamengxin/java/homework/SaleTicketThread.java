package com.shamengxin.java.homework;

public class SaleTicketThread extends Thread  {
    private Tickets ts;

    public SaleTicketThread(Tickets ts) {
        this.ts = ts;
    }

    @Override
    public void run() {
        while(ts.saleId<=ts.num){
            try {
                ts.saleTicket();
            } catch (SaleOfTicketsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
