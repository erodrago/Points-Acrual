package com.erodev.pointsaccrual;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.Period;

public class PointsComputation {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public double calculatePoints(LocalDate date, String seniority){

        double points = 0;
        LocalDate today = LocalDate.now();
        Period time = Period.between(date, today);
        int months = time.getMonths();

        points = months * seniorPoints(seniority) ;
        points = calcTenure(months) * points;
        return points;
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
