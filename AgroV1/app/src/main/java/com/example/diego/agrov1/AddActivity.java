package com.example.diego.agrov1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by diego on 19/03/2017.
 */

public class AddActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

    }


    public void Add(View view){

        String name, cult, lat, lon, ext;

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

        if ((name == null) || (cult == null) || (lat == null) || (lon == null) || (ext == null)){

            CharSequence texto = " Rellene todos los campos" ;
            Toast toast = Toast.makeText(AddActivity.this, texto, Toast.LENGTH_LONG);
            toast.show();
        }

    }

}
