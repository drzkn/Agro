package com.example.diego.agrov1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        list = (ListView)findViewById(R.id.listview_listado);
        //Explotacion[] eprima = new Explotacion[2];
        ArrayList esegunda = new ArrayList<Explotacion>();
        Explotacion[] eprima;
        Explotacion e;
        Date d;
        d = new Date();
        e = new Explotacion("1","Valle de Aranguren 1",1,1,1,d,"trigo");
        esegunda.add(e);
        e = new Explotacion("2","Valle de Aranguren 2",1,1,1,d,"trigo");
        esegunda.add(e);
        eprima = fromArrayListToArray(esegunda);

        //ArrayAdapter<Explotacion> adapter = new ArrayAdapter<Explotacion>(this, android.R.layout.simple_list_item_1, eprima);
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sistemas);

        //list.setAdapter(adapter);;

        list = (ListView) findViewById(R.id.listview_listado);
        list.setAdapter(new ListaAdaptador(this, R.layout.element, esegunda){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView1);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Explotacion) entrada).toString());

                }
            }
        });

        final Intent intent = new Intent(this, UpdateActivity.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Explotacion elegido = (Explotacion) pariente.getItemAtPosition(posicion);

                /*CharSequence texto = "Seleccionado: " + elegido.toString();
                Toast toast = Toast.makeText(MainPage.this, texto, Toast.LENGTH_LONG);
                toast.show();*/
                intent.putExtra("parametro",elegido);
                startActivity(intent);

            }
        });

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

    public void toAdd (View view){

            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);

    }



}
