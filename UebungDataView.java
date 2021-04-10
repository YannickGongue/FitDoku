package com.example.thejoega.fitdoku;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UebungDataView extends AppCompatActivity {

    protected Cursor cursor;
    TextView text1,text2,text3,text4 ,text5;
    Button btnview;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebung_data_view);
        dbHelper = new DatabaseHelper(this);
        text1=(TextView)findViewById(R.id.NummerUbView);
        text2=(TextView)findViewById(R.id.UbungNameView);
        text3=(TextView)findViewById(R.id.GeraetUbNameView);
        text4=(TextView)findViewById(R.id.editAnsatzUbView);
        text5=(TextView)findViewById(R.id.editDatumUbView);


        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Ubungdata WHERE name ='"+
                getIntent().getStringExtra("name")+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        btnview=(Button)findViewById(R.id.UbungView);
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
