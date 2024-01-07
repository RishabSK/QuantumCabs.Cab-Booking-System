package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class cabbookingop {




    public static void freecabfinder(char pick,char drop,  int time){
        Scanner  ip = new Scanner((System.in));
        char curloc;
        int atime;
        int earn;
        int cnum=0;
        int min = Integer.MAX_VALUE;
        int max=10;
        for(int i=1;i<=4;i++){
            Cab cb = Main.cabinfo.get(i);
            curloc= cb.location;
            atime= cb.avltime;
            earn = cb.earning;
            int distdiff = Math.abs(curloc-pick);
            int timediff = Math.abs(atime-time);

            if(timediff>=distdiff && distdiff<=max){

                if(distdiff<=max && earn<=min){
                    min = earn;
                    cnum= cb.cabnumber;
                }else if(distdiff<max){
                    cnum = cb.cabnumber;
                    min = earn;
                }
                max= distdiff;
            }else{
                System.out.println("No Cab Available");
                Main.main(null);
            }
        }
       // System.out.println("Cab "+ cnum +"is booked");
        int dist = Math.abs(pick-drop);
        int initialfare = 100;
        int totalfare = initialfare + ((dist*15)-5)*10;
        System.out.println("Total fare from "+pick+" to "+drop+" is "+totalfare);
        System.out.println("Cab "+ cnum +"is available");
        System.out.println("To book press Y, To cancel press N");
        char book = ip.next().charAt(0);
        if (book == 'Y') {
            System.out.println("Cab "+ cnum +" is booked at "+time+" in "+pick);
           Cab up =  Main.cabinfo.get(cnum);
           up.avltime = time+dist;
           up.earning = totalfare;
           up.location = drop;

           Cabhistory ub = new Cabhistory(cnum,pick,drop,time, up.avltime, totalfare);
           Main.cabdata.add(ub);
            ArrayList <Cabhistory> temp = new ArrayList<>();
           for(Cabhistory cv :Main.cabdata ){

               if(cv.cabnum==cnum){

                   temp.add(cv);
                   Main.cabhist.put(cnum,temp);
               }
           }

        }else{
            System.out.println("Booking is Cancelled");
        }
    }

    public void Cabdatadisplayer(){
        System.out.println("cusid "+"bookid "+"from "+"to "+"fare ");
        for(int i=1;i<=4;i++){
           ArrayList <Cabhistory> dp  = Main.cabhist.get(i);
           Cab val = Main.cabinfo.get(i);
            System.out.println("Cab "+i+" Total earning"+val.earning);
           for(Cabhistory cb:dp){
               System.out.println(cb.bookingid+" "+cb.customerid+" "+cb.pickup+" "+cb.drop+" "+cb.fare);
           }
        }
    }




}
