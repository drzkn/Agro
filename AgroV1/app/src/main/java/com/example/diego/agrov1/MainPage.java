package com.example.diego.agrov1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by diego on 07/03/2017.
 */

public class MainPage extends AppCompatActivity{

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_activity);

        list = (ListView)findViewById(R.id.list);
        //Explotacion[] eprima = new Explotacion[2];
        ArrayList esegunda = new ArrayList<Explotacion>();
        Explotacion[] eprima;
        Explotacion e;
        Date d;
        d = new Date();
        Cultivo c;
        c = new Cultivo("1", "trigo", 20);
        e = new Explotacion("1","Valle de Aranguren 1",1,1,1,d,c);
        esegunda.add(e);
        e = new Explotacion("2","Valle de Aranguren 2",1,1,1,d,c);
        esegunda.add(e);
        eprima = fromArrayListToArray(esegunda);

        ArrayAdapter<Explotacion> adapter = new ArrayAdapter<Explotacion>(this, android.R.layout.simple_list_item_1, eprima);
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sistemas);

        list.setAdapter(adapter);;

    }

    public Explotacion[] fromArrayListToArray(ArrayList<Explotacion> _arrayExplo){

        Explotacion[] _aux = new Explotacion[_arrayExplo.size()];
        Iterator<Explotacion> iExplotacion = _arrayExplo.iterator();
        int pos = 0;
        while ( iExplotacion.hasNext()){

            Explotacion e = iExplotacion.next();
            _aux[pos] = e;
            pos++;

        }

        return _aux;

    }

    public void toExplotacion(){


    }


}
