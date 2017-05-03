package com.example.diego.agrov1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by diego on 19/03/2017.
 */

public class AddActivity extends AppCompatActivity {

    private ParseObject explotacion;
    private Intent intent;
    private String name, cult;
    private String lat,lon,ext;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        EditText e = (EditText) findViewById(R.id.editText1);
        name = e.getText().toString();

        e = (EditText) findViewById(R.id.editText2);
        cult = e.getText().toString();

        e = (EditText) findViewById(R.id.editText3);
        lat = e.getText().toString();

        e = (EditText) findViewById(R.id.editText4);
        lon = e.getText().toString();

        e = (EditText) findViewById(R.id.editText5);
        ext = e.getText().toString();

    }


    public void Add(View view){

        EditText e = (EditText) findViewById(R.id.editText1);
        name = e.getText().toString();

        e = (EditText) findViewById(R.id.editText2);
        cult = e.getText().toString();

        e = (EditText) findViewById(R.id.editText3);
        lat = e.getText().toString();
        //lat = new Long (Long.parseLong(auxlat));

        e = (EditText) findViewById(R.id.editText4);
        lon = e.getText().toString();
        //lon = new Long (Long.parseLong(e.getText().toString()));

        e = (EditText) findViewById(R.id.editText5);
        ext = e.getText().toString();
        //ext = new Long (Long.parseLong(auxext));


        if ( CheckName() || CheckCult() || CheckLat() || CheckLon() || CheckExt() ){

            CharSequence texto = " Rellene todos los campos" ;
            Toast toast = Toast.makeText(AddActivity.this, texto, Toast.LENGTH_LONG);
            toast.show();

        }else{

            explotacion = new ParseObject("Explotacion");
            Date d = new Date();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            explotacion.put("name", name);
            explotacion.put("cult",cult);
            explotacion.put("lat",lat);
            explotacion.put("lon",lon);
            explotacion.put("ext",ext);
            explotacion.put("date",df.format(d));
            explotacion.saveInBackground();

            explotacion.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(
                                getBaseContext(),
                                "Nueva explotacion añadida con id: " + explotacion.getObjectId(),
                                Toast.LENGTH_SHORT).show();
                        Log.v("newParseObject(): object saved in server: " + explotacion.getObjectId(), "newParseObject()");
                    } else {
                        Log.v("newParseObject(): Object save failed  to server, reason: "+ e.getMessage(), "newParseObject()");
                        Toast.makeText(
                                getBaseContext(),
                                "newParseObject(): Object save failed  to server, reason: "+ e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }


                }

            });

            intent = new Intent(this, MainPage.class);
            startActivity(intent);
            finish();

        }

    }

    public boolean CheckName(){

        return (name.isEmpty());
    }

    public boolean CheckCult(){

        return (cult.isEmpty());
    }

    public boolean CheckLon(){

        return (lon.isEmpty());

    }

    public boolean CheckLat(){

        return (lat.isEmpty());

    }

    public boolean CheckExt(){

        return (ext.isEmpty());
    }

}
