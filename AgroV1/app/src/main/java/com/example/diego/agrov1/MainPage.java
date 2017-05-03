package com.example.diego.agrov1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

/**
 * Created by diego on 07/03/2017.
 */

public class MainPage extends AppCompatActivity{

    private ListView list;
    private String id,name,abon,cult;
    private String auxlon,auxlat,auxext;
    private float ext,lat,lon;
    private Explotacion ex;
    private ArrayList esegunda = new ArrayList<Explotacion>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_activity);

        list = (ListView)findViewById(R.id.listview_listado);
        //These lines were used when we didn't have the connection with dthe server
        /*Explotacion[] eprima = new Explotacion[2];
        Date d;
        lat = (float) 42.7892159;
        lon = (float) -1.6123983;
        //d = new Date();
        ex = new Explotacion("1","Ejemplo 1",1,lat,lon,"3-5-2017","Trigo");
        esegunda.add(ex);
        ex = new Explotacion("2","Valle de Aranguren 2",1,lat,lon,"3-5-2017","Trigo");
        esegunda.add(ex);
        eprima = fromArrayListToArray(esegunda);*/

        //These lines are used to work with the server
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Explotacion");
        query.whereExists("name");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> explotacionList, ParseException e) {
                if (e == null) {

                    Log.d("Explotacion", "Retrieved " + explotacionList.size() + " explotaciones");

                    CharSequence texto = "Se han conseguido " + explotacionList.size() + " explotaciones";
                    Toast toast = Toast.makeText(getBaseContext(),texto,Toast.LENGTH_SHORT);
                    toast.show();

                    Iterator<ParseObject> it = explotacionList.iterator();
                    ParseObject o;
                    Explotacion ex;
                    //Explotacion[] eprima;

                    while (it.hasNext()){

                        o = it.next();

                        name=o.getString("name");
                        id=o.getObjectId();
                        abon=o.getString("date");
                        cult=o.getString("cult");
                        lon=o.getLong("lon");
                        lat=o.getLong("lat");
                        ext=o.getLong("ext");

                        texto = id;
                        toast = Toast.makeText(getBaseContext(),texto,Toast.LENGTH_SHORT);
                        toast.show();


                        ex=new Explotacion(id,name,ext,lat,lon,abon, cult);
                        esegunda.add(ex);

                        list = (ListView) findViewById(R.id.listview_listado);
                        list.setAdapter(new ListaAdaptador(getBaseContext(), R.layout.element, esegunda){
                            @Override
                            public void onEntrada(Object entrada, View view) {
                                if (entrada != null) {
                                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView1);
                                    if (texto_superior_entrada != null)
                                        texto_superior_entrada.setText(((Explotacion) entrada).toString());

                                }
                            }
                        });

                    }


                } else {
                    Log.d("Explotacion", "Error: " + e.getMessage());
                }
            }
        });

        //ArrayAdapter<Explotacion> adapter = new ArrayAdapter<Explotacion>(this, android.R.layout.simple_list_item_1, eprima);
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sistemas);

        //list.setAdapter(adapter);;


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
