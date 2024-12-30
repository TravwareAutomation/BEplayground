package com.example.beaportal;

import java.util.Calendar;

public class Utilities {

    static int TargetDay=0,TargetMonth=0,TargetYear=0;
    static int CurrentDay=0,CurrentMonth=0,CurrentYear=0;
    static int JumpToMonth=0;
    static boolean increment=true;


    public static void getTargetDate(String DateToSet) {
        int FirstIndex=DateToSet.indexOf("/");
        int LastIndex=DateToSet.lastIndexOf("/");
        String Day=DateToSet.substring(0,FirstIndex);
        String Month=DateToSet.substring(FirstIndex+1,LastIndex);
        String Year=DateToSet.substring(LastIndex+1,DateToSet.length()+1);
        TargetDay=Integer.parseInt(Day);
        TargetMonth=Integer.parseInt(Month);
        TargetYear=Integer.parseInt(Year);


    }
    public static void getCurrentDate(){
        Calendar calender=Calendar.getInstance();
        CurrentDay=calender.get(Calendar.DAY_OF_MONTH);
        CurrentMonth = calender.get(Calendar.MONTH)+1;
        CurrentYear = calender.get(Calendar.YEAR);
    }
    public static void calculateMonthsToJump(){
        if ((TargetMonth-CurrentMonth)>0){JumpToMonth=TargetMonth-CurrentMonth;}
        else {JumpToMonth=CurrentMonth-TargetMonth;increment=false;}
    }
}
