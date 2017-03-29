package com.example.diego.agrov1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by diego on 19/03/2017.
 */

public class UpdateActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);

        Explotacion objeto = (Explotacion)getIntent().getExtras().getSerializable("parametro");

        EditText e = (EditText) findViewById(R.id.editText1);
        e.setText(objeto.getName());

        e = (EditText) findViewById(R.id.editText2);
        e.setText(objeto.getCult());

        e = (EditText) findViewById(R.id.editText3);
        e.setText(String.valueOf(objeto.getLon()));

        e = (EditText) findViewById(R.id.editText4);
        e.setText(String.valueOf(objeto.getLat()));

        e = (EditText) findViewById(R.id.editText5);
        e.setText(String.valueOf(objeto.getExt()));

    }

    public void Update (View view){

        /*  Tengo que ver como hago esto para que me actualice la explotacion que quiero

        EditText e = (EditText) findViewById(R.id.editText1);
        e.setText(objeto.getName());

        e = (EditText) findViewById(R.id.editText2);
        e.setText(objeto.getCult());

        e = (EditText) findViewById(R.id.editText3);
        e.setText(String.valueOf(objeto.getLon()));

        e = (EditText) findViewById(R.id.editText4);
        e.setText(String.valueOf(objeto.getLat()));

        e = (EditText) findViewById(R.id.editText5);
        e.setText(String.valueOf(objeto.getExt()));
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);*/

        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
        finish();


    }

}
