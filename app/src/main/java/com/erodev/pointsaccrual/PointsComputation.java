package com.erodev.pointsaccrual;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PointsComputation {

        public double calculatePoints(String date, String seniority){

//        double points = 0;
//        LocalDate today = LocalDate.now();
//        Period time = Period.between(date, today);
//        int months = time.getMonths();
//
//        points = months * seniorPoints(seniority) ;
//        points = calcTenure(months) * points;



//        date.concat(" 00:00:00");
//
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat(
//                "yyyy/MM/dd HH:mm:ss");
//
//        try {
//
//            Date emplDate = dateFormat.parse(date);
//
//            Date currentDate = new Date();
//
//            long diff = currentDate.getTime() - emplDate.getTime();
//            long seconds = diff / 1000;
//            long minutes = seconds / 60;
//            long hours = minutes / 60;
//            long days = hours / 24;
//
//            long months = days/30;
//
//            return points;
//
//        } catch (ParseException e) {
//
//            e.printStackTrace();
//        }


        return 0;

    }


    public double seniorPoints(String letter){
        if(letter == "A"){
            return 5;
        }else if(letter == "B"){
            return 10;
        }else if(letter == "C"){
            return 15;
        }else if(letter == "D"){
            return 20;
        }else if(letter == "E"){
            return 25;
        }else{
            return 0;
        }


    }


    public double calcTenure(int months){

        if(months <= 2){
            return 1;

        }else if(months>2 && months<=4){
            return 1.25;

        }else if(months > 4){
            return 1.5;
        }
        return 0;
    }



}
