package com.example.thejoega.fitdoku;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class neuer_tplan extends AppCompatActivity {

    private static final String TAG = "neuer_tplan";

    private TextView nDisplayDate;

    private DatePickerDialog.OnDateSetListener onDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(neuer_tplan.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_neuer_tplan, null);

         nDisplayDate =(TextView) mView.findViewById(R.id.tp_datum2);
        Spinner myspinner = (Spinner) mView.findViewById(R.id.spinner2);
        Button mybutton = (Button) mView.findViewById(R.id.ntp_button);


        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(neuer_tplan.this, Trainingsplaene.class);
                startActivity(myIntent);
                finish();

            }
        });
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(neuer_tplan.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tr_spinner));

        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);


        nDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(neuer_tplan.this,
                        android.R.style.Theme_DeviceDefault_Light,
                        onDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;

                Log.d(TAG, "onDateSet: mm/dd/yyy:" + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                nDisplayDate.setText(date);

            }
        };

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

    }

}
