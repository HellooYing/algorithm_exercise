package com.toutiao.aspect;

import java.util.Scanner;

public class MT20190528 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        in.close();
        System.out.println(new MT20190528().getBusinessHour(s));
    }
    public String getBusinessHour(String str){
        if(str.equals("111111111111111111111111111111111111111111111111")){
            return "allDay";
        }

        else if(str.equals("000000000000000000000000000000000000000000000000")){
            return "no work";
        }

        else{
            char[] workTime=str.toCharArray();
            int startWorkTime=20;
            while(startWorkTime<48&&workTime[startWorkTime]=='0'){
                startWorkTime++;
            }
            if(startWorkTime>24+8){
                return "no work";
            }
            int endWorkTime=startWorkTime+1;
            while(endWorkTime<24+8&&workTime[endWorkTime]!='0')
                endWorkTime++;
            if(endWorkTime==24+8) endWorkTime--;
            if(startWorkTime==20&&endWorkTime<24){
                return "Today"+startWorkTime+"clock to "+endWorkTime+"clock work";
            }
            if(startWorkTime==20&&endWorkTime<24+8){
                endWorkTime-=24;
                return "Today"+startWorkTime+"clock to tomorroy"+endWorkTime+"clock work";
            }
            if(startWorkTime>=24){
                startWorkTime-=24;
                endWorkTime-=24;
                return "tomorroy"+startWorkTime+"clock to"+endWorkTime+"clock work";
            }

        }
        return null;
    }
}