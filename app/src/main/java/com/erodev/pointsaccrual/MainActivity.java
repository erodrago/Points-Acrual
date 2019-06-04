package com.erodev.pointsaccrual;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    List<Employee> emplist;
    private RecyclerView myrv;
    SearchView searchView;
    AcrualRecyclerViewAdapter adapter;

    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefManager = new PrefManager(this);



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


        searchView = findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(this);
        myrv = findViewById(R.id.recyclerview_id);
        myrv.setHasFixedSize(true);
        myrv.setLayoutManager(new LinearLayoutManager(this));


        adapter = new AcrualRecyclerViewAdapter(getApplicationContext(), emplist);
        myrv.setAdapter(adapter);

    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        String text = s;
//        adapter.getItemViewType().filter(text);
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            prefManager.setFirstTimeLaunch(true);
            if(prefManager.isFirstTimeLaunch()){
            launchLoginPage();
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void launchLoginPage() {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
