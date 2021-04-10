package com.example.thejoega.fitdoku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Startseite extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*public final EditText n_edit = findViewById(R.id.edit_name);
    public  final EditText ge_edit = findViewById(R.id.edit_gewicht);
    public final EditText al_edit = findViewById(R.id.edit_alter);
    public final EditText gr_edit = findViewById(R.id.edit_groesse);
*/
    String items[]=  new String[]{
            "Ausdauertraining",
            "Krafttraining",
            "Vibrationstraining",
            "Sonstiges Training"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startseite);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listview = (ListView) findViewById(R.id.Trainingsarten);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);

                // Return the view
                return view;
            }
        };
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position== 0) {
                    Intent myIntent = new Intent(Startseite.this, ausdauertraining.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position== 1) {
                    Intent myIntent = new Intent(Startseite.this, krafttraining.class);
                    startActivityForResult(myIntent, 1);
                }
                if (position== 2) {
                    Intent myIntent = new Intent(Startseite.this, vibrationstraining.class);
                    startActivityForResult(myIntent, 2);
                }
                if (position== 3) {
                    Intent myIntent = new Intent(Startseite.this, sonstigestraining.class);
                    startActivityForResult(myIntent, 3);
                }

            }
        });
     //AKtion nach dem Drücken von plus button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Startseite.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_neues, null);

                Button neuer_tp = (Button) mView.findViewById(R.id.n_tp);
                Button neue_ubg = (Button) mView.findViewById(R.id.n_ueb);
                Button neues_ger = (Button) mView.findViewById(R.id.n_gr);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                neuer_tp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(Startseite.this, neuer_tplan.class);
                        startActivity(myIntent);
                    }
                });

                neue_ubg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(Startseite.this, neue_ueb.class);
                        startActivity(myIntent);
                    }
                });

                neues_ger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(Startseite.this, neues_geraet.class);
                        startActivity(myIntent);
                    }
                });
            }
        });
       //Menu Liste
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the Startseite; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pr) {

            Intent myIntent = new Intent(Startseite.this, profil.class);
            startActivity(myIntent);
           /* AlertDialog.Builder mBuilder = new AlertDialog.Builder(Startseite.this);
            View mView = getLayoutInflater().inflate(R.layout.activity_profil, null);

           // Button mybutton = (Button) mView.findViewById(R.id.pro_button);

            mBuilder.setView(mView);
            final AlertDialog dialog = mBuilder.create();
            dialog.show();

            mybutton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                Intent myIntent = new Intent(Startseite.this, Startseite.class);
                                                startActivity(myIntent);
                                                SharedPreferences sharedPrefs = getSharedPreferences("SFile", 0);

                                                n_edit.setText(sharedPrefs.getString("mykey1","Name"));
                                                ge_edit.setText(sharedPrefs.getString("mykey2","Gewicht"));
                                                al_edit.setText(sharedPrefs.getString("mykey3","Alter"));
                                                gr_edit.setText(sharedPrefs.getString("mykey4","Groesse"));
                                            }

                                        });*/



                    // Handle the camera action
        }else if (id == R.id.nav_tp) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(Startseite.this);
            View mView = getLayoutInflater().inflate(R.layout.activity_trainingsplaene, null);

            Button at_button = (Button) mView.findViewById(R.id.at_tpln);
            Button kt_button = (Button) mView.findViewById(R.id.kt_tpln);
            Button vt_button = (Button) mView.findViewById(R.id.vt_tpln);
            Button st_button = (Button) mView.findViewById(R.id.st_tpln);

            mBuilder.setView(mView);
            final AlertDialog dialog = mBuilder.create();
            dialog.show();

            at_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Startseite.this, at_tp.class);
                            startActivity(myIntent);
                            finish();
                        }
                    });
            kt_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Startseite.this,kt_tp.class);
                            startActivity(myIntent);
                            finish();

                        }
                    });
            vt_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Startseite.this, vt_tp.class);
                            startActivity(myIntent);
                            finish();

                        }
                    });
            st_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Startseite.this, st_tp.class);
                            startActivity(myIntent);
                            finish();

                        }
                    });

            // Handle the camera action
        } else if (id == R.id.nav_ueb) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(Startseite.this);
            View mView = getLayoutInflater().inflate(R.layout.activity_uebungen, null);

            Button at_button = (Button) mView.findViewById(R.id.at_uebn);
            Button kt_button = (Button) mView.findViewById(R.id.kt_uebn);
            Button vt_button = (Button) mView.findViewById(R.id.vt_uebn);
            Button st_button = (Button) mView.findViewById(R.id.st_uebn);

            mBuilder.setView(mView);
            final AlertDialog dialog = mBuilder.create();
            dialog.show();

            at_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(Startseite.this, at_ueb.class);
                    startActivity(myIntent);
                }
            });
            kt_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(Startseite.this,kt_ueb.class);
                    startActivity(myIntent);
                }
            });
            vt_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(Startseite.this, vt_ueb.class);
                    startActivity(myIntent);

                }
            });
            st_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(Startseite.this, st_ueb.class);
                    startActivity(myIntent);

                }
            });
        } else if (id == R.id.nav_ger) {
            Intent myIntent = new Intent(Startseite.this, geraete.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_st) {
            Intent myIntent = new Intent(Startseite.this, statistik.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
