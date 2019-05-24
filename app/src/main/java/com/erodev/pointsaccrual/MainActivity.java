package com.erodev.pointsaccrual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Employee> emplist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emplist = new ArrayList<>();
        emplist.add(new Employee(1, "Ero", "B", "2016/01/02"));
        emplist.add(new Employee(2, "Ann", "C", "2018/11/12"));
        emplist.add(new Employee(3, "John", "B", "2017/04/02"));
        emplist.add(new Employee(4, "Doe", "A", "2015/05/27"));
        emplist.add(new Employee(5, "Sam", "C", "2016/05/20"));
        emplist.add(new Employee(6, "Fred", "D", "2017/05/01"));
        emplist.add(new Employee(7, "Bito", "A", "2019/03/14"));
        emplist.add(new Employee(8, "Ari", "D", "2018/05/30"));
        emplist.add(new Employee(9, "Dany", "B", "2015/12/01"));

    }
}
