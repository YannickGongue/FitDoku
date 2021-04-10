package com.example.thejoega.fitdoku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by yan on 25/07/2019.
 */

public class DatabaseHelper2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME3 ="Trainingsplaene.db";

    private static final int DATABASE_VERSION =1;
    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME3, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String sql3 = "create table Trainingsplaene( nummer integer primary key,trainingsname text null ," +
                "uebung text null, geraet integer null, datum text null);";
        Log.d("Data","onCreate: "+sql3);
        db.execSQL(sql3);
    }
    @Override
    public  void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

}
