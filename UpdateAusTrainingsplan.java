package com.example.thejoega.fitdoku;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateAusTrainingsplan extends AppCompatActivity {

    protected Cursor cursor;
    EditText text1,text2,text3,text4 ,text5;
    Button BtnaddUp1,BtnabbrUp2;
    DatabaseHelper2 dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_aus_trainingsplan);
        dbHelper = new DatabaseHelper2(this);
        text1=(EditText)findViewById(R.id.EditAuNummTpUp);
        text2=(EditText)findViewById(R.id.editAuTpNameUp);
        text3=(EditText)findViewById(R.id.editAuUbungTPUp);
        text4=(EditText)findViewById(R.id.editAuGeraetTpUp);
        text5 = (EditText)findViewById(R.id.editAuDatumTpUp);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM Trainingsplaene WHERE trainingsname='" +
                getIntent().getStringExtra("trainingsname")+ "'",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        BtnabbrUp2 = (Button)findViewById(R.id.AbbrbtnUP);
        BtnaddUp1 = (Button)findViewById(R.id.AddBtnUp);
        BtnaddUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update Trainingsplaene set trainingsname='"+
                        text2.getText().toString()+"', uebung='"+
                        text3.getText().toString()+"', geraet='"+
                        text4.getText().toString()+"', datum='"+
                        text5.getText().toString()+"'where nummer='"+
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(),"gespeichert",Toast.LENGTH_LONG).show();
                at_tp.ma.Refreshlist2();
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
