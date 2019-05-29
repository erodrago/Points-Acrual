package com.erodev.pointsaccrual;


import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;



public class PointsComputation {




    public double calculatePoints(String date, String seniority){

        // Get months between these date and today.

        int months = noOfMonths(date);

        double points = 0;

        points = months * seniorPoints(seniority) ;
        points = calcTenure(months) * points;


        return points;

    }

    private int noOfMonths(String date) {


        DateTime startDate = DateTime.parse(date, DateTimeFormat.forPattern("yyyy/MM/dd"));

        DateTime now = DateTime.now().withTimeAtStartOfDay();
        String tod = String.valueOf(now);
        String [] parts = tod.split("T");
        String today1 = parts[0];

        DateTime today = DateTime.parse(today1, DateTimeFormat.forPattern("yyyy-MM-dd"));

        int months = Months.monthsBetween(startDate.withDayOfMonth(1), DateTime.now().withTimeAtStartOfDay().withDayOfMonth(1)).getMonths();

        return months;

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
