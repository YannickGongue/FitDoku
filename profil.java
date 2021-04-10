package com.example.thejoega.fitdoku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class profil extends AppCompatActivity {

    Button msave,mclose;
    EditText mname,mgewicht, malter,mgroesse;
    SharedPreferences mshare;
    SharedPreferences.Editor mEditor;
    boolean saveprofil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        mname = (EditText) findViewById(R.id.edit_name);
        mgewicht =(EditText) findViewById(R.id.edit_gewicht);
        malter =(EditText) findViewById(R.id.edit_alter);
        mgroesse =(EditText) findViewById(R.id.edit_groesse);

        msave = findViewById(R.id.pro_button1);
        mclose = findViewById(R.id.pro_button2);

        mshare = getSharedPreferences("mfile",MODE_PRIVATE);
        mEditor = mshare.edit();

        msave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storage();
            }
        });

        mclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(profil.this, Startseite.class);
                startActivity(myIntent);
            }
        });
        saveprofil = mshare.getBoolean("saveprofil",true);

        if (saveprofil == true){
            mname.setText(mshare.getString("name",null));
            mgewicht.setText(mshare.getString("gewicht",null));
            malter.setText(mshare.getString("alter",null));
            mgroesse.setText(mshare.getString("groesse",null));
        }
    }



    private void storage() {
        String uname = mname.getText().toString();
        String ugewicht = mgewicht.getText().toString();
        String ualter = malter.getText().toString();
        String ugroesse = mgroesse.getText().toString();


        mEditor.putBoolean("saveprofil", true);
        mEditor.putString("name", uname);
        mEditor.putString("gewicht", ugewicht);
        mEditor.putString("alter", ualter);
        mEditor.putString("groesse", ugroesse);

        boolean saved = mEditor.commit();

        if (saved == true) {
            Toast.makeText(this, "The Content have been saved", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();

        }
    }

}


