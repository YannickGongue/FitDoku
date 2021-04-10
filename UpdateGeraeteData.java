package com.example.thejoega.fitdoku;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateGeraeteData extends AppCompatActivity {

    protected Cursor cursor;
    EditText text1,text2,text3,text4 ,text5;
    Button BtnaddUp1,BtnabbrUp2;
    databaseHelper1 dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_geraete_data);
            dbHelper = new databaseHelper1(this);
        text1=(EditText)findViewById(R.id.editNummGeraetUp);
        text2=(EditText)findViewById(R.id.editGeraetNameUp);
        text3=(EditText)findViewById(R.id.editEigenGeraetUp);
        text4=(EditText)findViewById(R.id.editGeraeteAnsatzUp);
        text5 = (EditText)findViewById(R.id.editGeraetDatumUp);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM geraet WHERE geraetsname='" +
                getIntent().getStringExtra("geraetsname")+ "'",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        BtnabbrUp2 = (Button)findViewById(R.id.AbbrGeraetUP);
        BtnaddUp1 = (Button)findViewById(R.id.AddGeraetUp);
        BtnaddUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(" update geraet set geraetsname='"+
                        text2.getText().toString()+"', geraetseigen='"+
                        text3.getText().toString()+"', geraetsansatz='"+
                        text4.getText().toString()+"', geraetsdatum='"+
                        text5.getText().toString()+"' where nummer='"+
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(),"gespeichert",Toast.LENGTH_LONG).show();
                geraete.ma.Refreshlist1();
                finish();
            }
        });
        BtnabbrUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
