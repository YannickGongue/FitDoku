package com.example.thejoega.fitdoku;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class neue_ueb extends AppCompatActivity {

    protected Cursor cursor;
    EditText text1,text2,text3,text4 ,text5;
    Button btnadd1,btnabbr2;
    DatabaseHelper dbHelper;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neue_ueb);
        text1 = (EditText) findViewById(R.id.EditNeuenummUb);
        text2 = (EditText) findViewById(R.id.editNeuUbName);
        text3 = (EditText) findViewById(R.id.editNeuGeraetName);
        text4 = (EditText) findViewById(R.id.editNeuAnsatz);
        text5=  (EditText) findViewById(R.id.editNeuDatum);

        btnadd1 = (Button) findViewById(R.id.AddNeuUbung);
        btnabbr2 = (Button) findViewById(R.id.Abbrbutton2);
        dbHelper = new DatabaseHelper(this);

        btnadd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into Ubungdata (nummer, name, geraete,ansatz,datum) values('"+
                        text1.getText().toString()+"','"+
                        text2.getText().toString()+"','"+
                        text3.getText().toString()+"','"+
                        text4.getText().toString()+"','"+
                        text5.getText().toString()+"')");
                Toast.makeText(getApplicationContext(),"gespeichert",Toast.LENGTH_LONG).show();
                at_ueb.ma.Refreshlist();
                finish();
            }
        });
        btnabbr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}



