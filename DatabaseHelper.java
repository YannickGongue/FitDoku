package com.example.thejoega.fitdoku;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by thejoega on 27.02.2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME ="Ubungdata.db";
    private static final String DATABASE_NAME1 ="Trainingsplan.db";


    private static final int DATABASE_VERSION =1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table Ubungdata( nummer integer primary key,name text null ," +
                "geraete text null, ansatz integer null, datum text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);

        String sql1 = "create table Trainingsplan( nummer integer primary key,name text null ," +
                "geraete text null, ansatz integer null, datum text null);";
        Log.d("Data","onCreate: "+sql1);
        db.execSQL(sql1);

        String sql2 = "create table geraet( nummer integer primary key,geraetsname text null ," +
                "geraetseigen text null, geraetsansatz integer null, geraetsdatum text null);";
        Log.d("Data","onCreate: "+sql2);
        db.execSQL(sql2);
    }
    @Override
    public  void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

}
