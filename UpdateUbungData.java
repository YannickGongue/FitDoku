package com.example.thejoega.fitdoku;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateUbungData extends AppCompatActivity {

    protected Cursor cursor;
    EditText text1,text2,text3,text4 ,text5;
    Button BtnaddUp1,BtnabbrUp2;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_uebung_data);
    dbHelper = new DatabaseHelper(this);
    text1=(EditText)findViewById(R.id.EditNummUp);
    text2=(EditText)findViewById(R.id.editUbNameUp);
    text3=(EditText)findViewById(R.id.editGeraetUp);
    text4=(EditText)findViewById(R.id.editAnsatzUp);
    text5 = (EditText)findViewById(R.id.editDatumUp);

    SQLiteDatabase db = dbHelper.getWritableDatabase();
    cursor = db.rawQuery("SELECT * FROM Ubungdata WHERE name='" +
    getIntent().getStringExtra("name")+ "'",null);
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
            db.execSQL("update Ubungdata set name='"+
                    text2.getText().toString()+"', geraete='"+
                    text3.getText().toString()+"', ansatz='"+
                    text4.getText().toString()+"', datum='"+
                    text5.getText().toString()+"'where nummer='"+
                    text1.getText().toString()+"'");
            Toast.makeText(getApplicationContext(),"gespeichert",Toast.LENGTH_LONG).show();
            at_ueb.ma.Refreshlist();
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
