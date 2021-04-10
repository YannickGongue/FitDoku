package com.example.thejoega.fitdoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Burpees extends AppCompatActivity {

    String items1[] = new String[]{
            "Radfahren",
            "Crosstrainer",
            "Ergometer",
            "Heimtrainer",
            "Laufbänder",
            "Rudergeräte",
            "Skilanglauf-Trainer",
            "Stepper",
            "Trampolin",
            "Zubhör Ausdauer"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_edit_uebung);
    }
}
