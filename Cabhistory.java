package com.company;

public class Cabhistory {
    int cabnum;
   static int customerid=1;
    int bookingid;
    char pickup;
    char drop;
    int fare;
    int picktime;
    int droptime;
    public Cabhistory(int cabnum, char pickup, char drop,int picktime,int droptime,int fare){
        this.cabnum = cabnum;
        this.customerid = customerid++;
        this.bookingid = customerid;
        this.pickup = pickup;
        this.drop = drop;
        this.fare = fare;
    }
}
