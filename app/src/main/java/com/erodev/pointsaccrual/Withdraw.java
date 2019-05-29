package com.erodev.pointsaccrual;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Withdraw extends AppCompatActivity {


    TextView tvname;
    EditText edpoints;
    Button redeem;
    Double pointstodeduct;
    String position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        tvname = findViewById(R.id.tvname);
        edpoints = findViewById(R.id.edredeem);
        redeem = findViewById(R.id.btnredeem);



        String name, emppos;
        name = getIntent().getStringExtra("Name");
        emppos = getIntent().getStringExtra("empposition");
        tvname.setText("Hello "+name+",");

        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();

            }
        });


    }

    private void showAlertDialog(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Reedeem");
        builder.setMessage("Are you sure you want to redeem points?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                pointstodeduct = (Double.valueOf(edpoints.getText().toString()));
                Intent intent = new Intent(Withdraw.this,MainActivity.class);
                intent.putExtra("deduct", pointstodeduct);
                intent.putExtra("pos", position);


                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    }
}
