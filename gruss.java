package com.example.thejoega.fitdoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class gruss extends AppCompatActivity {
  Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gruss);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent myIntent = new Intent(gruss.this, Startseite.class);
                startActivity(myIntent);
                finish();
            }
        },2000);

    }

}