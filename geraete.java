package com.example.thejoega.fitdoku;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class geraete extends AppCompatActivity {

    String[] List1;
    ListView ListView2;
    Menu menu;
    protected Cursor cursor;
    databaseHelper1 dbcenter;
    public static geraete ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geraete);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(geraete.this, neues_geraet.class);
                startActivity(intent);
            }
        });
        ma = this;
        dbcenter = new databaseHelper1(this);
        Refreshlist1();
    }
    public  void Refreshlist1(){

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM geraet " , null);
        List1 = new String[cursor.getCount()];
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount();i++){
            cursor.moveToPosition(i);
            List1[i] = cursor.getString(1).toString();
        }
        ListView2 = (ListView)findViewById(R.id.aus_geraete);
        ListView2.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,List1));
        ListView2.setSelected(true);
        ListView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView arg0,View arg1,int arg2, long arg3){
                final String selection = List1[arg2];
                final CharSequence[] dialogitem = {"   create    ", "   Update  ", "  Delete  " };
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(geraete.this);
                //builder.setTitle("name");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), GeraetDataView.class);
                                i.putExtra("geraetsname", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(), UpdateGeraeteData.class);
                                in.putExtra("geraetsname", selection);
                                startActivity(in);
                                break;
                            case 2:
                                SQLiteDatabase db = dbcenter.getReadableDatabase();
                                db.execSQL("delete from geraet  where geraetsname = '" + selection + "'");
                                Refreshlist1();
                                break;

                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)ListView2.getAdapter()).notifyDataSetInvalidated();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.home) {

            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

}
