package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {



    static HashMap <Integer,Cab> cabinfo = new HashMap<>();
    static ArrayList <Cabhistory> cabdata = new ArrayList<>();
    static HashMap <Integer,ArrayList<Cabhistory>> cabhist = new HashMap <>();


    public static  void gettinguserinfo(int choice){
        switch(choice){
            case 1:{
                Scanner ip = new Scanner(System.in);

                System.out.println("Enter pickup point");
                char pickup = ip.next().charAt(0);

                System.out.println("Enter drop point");
                char drop = ip.next().charAt(0);

                System.out.println("Enter pickup time");
                int time = ip.nextInt();

                cabbookingop cb = new cabbookingop();
                cb.freecabfinder(pickup,drop,time);

            }break;

            case 2:{
                cabbookingop dp = new cabbookingop();
                dp.Cabdatadisplayer();
            }
        }

    }




    public static void main(String[] args) {
	// write your code here

        for(int i=1;i<=4;i++){
            Cab c = new Cab(i,'a',0,1);
            cabinfo.put(i,c);
        }
        Scanner ip = new Scanner(System.in);
        while(true){

            System.out.println("Welcome to Q Cabs!");
            System.out.println("To book a Cab press 1");
            System.out.println("To view Cab booking history press 2");
            int choice = ip.nextInt();
            gettinguserinfo(choice);
        }






    }
}
