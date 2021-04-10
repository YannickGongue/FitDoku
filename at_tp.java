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

public class at_tp extends AppCompatActivity {

    String[] List;
    ListView ListView1;
    Menu menu;
    protected Cursor cursor;
    DatabaseHelper2 dbcenter;
    public static at_tp ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_tp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(at_tp.this, Neu_at_pl.class);
                startActivity(intent);
            }
        });

        ma = this;
        dbcenter = new DatabaseHelper2(this);
        Refreshlist2();
    }
    public  void Refreshlist2(){

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Trainingsplaene " , null);
        List = new String[cursor.getCount()];
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount();i++){
            cursor.moveToPosition(i);
            List[i] = cursor.getString(1).toString();
        }
        ListView1 = (ListView)findViewById(R.id.aus_traininsplan);
        ListView1.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,List));
        ListView1.setSelected(true);
        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView arg0,View arg1,int arg2, long arg3){
                final String selection = List[arg2];
                final CharSequence[] dialogitem = {"   create    ", "   Update  ", "  Delete  " , " starten "};
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(at_tp.this);
                //builder.setTitle("name");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), AusTrainingsplanView.class);
                                i.putExtra("trainingsname", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(), UpdateAusTrainingsplan.class);
                                in.putExtra("trainingsname", selection);
                                startActivity(in);
                                break;
                            case 2:
                                SQLiteDatabase db = dbcenter.getReadableDatabase();
                                db.execSQL("delete from Trainingsplaene  where trainingsname = '" + selection + "'");
                                Refreshlist2();
                                break;
                            case 3:
                                Intent Gz = new Intent(getApplicationContext(), Tp_Starten.class);
                                Gz.putExtra("trainingsname", selection);
                                startActivity(Gz);
                                break;

                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)ListView1.getAdapter()).notifyDataSetInvalidated();
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
