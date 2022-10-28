package com.shamengxin.java.homework;

public class InitTickets extends Thread{
    Tickets ts;

    public InitTickets(Tickets ts) {
        this.ts = ts;
    }

    @Override
    public void run() {
        for (int i = 0; i <ts.num ; i++) {
            ts.tickets[i]=new Ticket(i);
        }
    }
}
