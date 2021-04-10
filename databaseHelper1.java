package com.example.thejoega.fitdoku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by yan on 25/07/2019.
 */

public class databaseHelper1 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME2 ="geraet.db";

    private static final int DATABASE_VERSION =1;
    public databaseHelper1(Context context) {
        super(context, DATABASE_NAME2, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String sql2 = "create table geraet( nummer integer primary key,geraetsname text null ," +
                "geraetseigen text null, geraetsansatz integer null, geraetsdatum text null);";
        Log.d("Data","onCreate: "+sql2);
        db.execSQL(sql2);
    }
    @Override
    public  void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

}
