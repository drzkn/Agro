package com.example.diego.agrov1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util

/**
 * Created by diego on 15/03/2017.
 */

public class Explotacion {

    private String id;
    private String name;
    private float ext;
    private float lat;
    private float lon;
    private Date abon;
    private Cultivo cult;

    @Override
    public String toString() {
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        return name + "\n" +
                "Estension " + ext + " hectareas" +
                "\nUltimo abonado\n" + d.format(abon) +
                "\n" + cult + "\n" ;
    }

    public Explotacion(String id, String name, float ext, float lat, float lon, Date abon, Cultivo cult) {

        this.id = id;
        this.name = name;
        this.ext = ext;
        this.lat = lat;
        this.lon = lon;
        this.abon = abon;
        this.cult = cult;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getExt() {
        return ext;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public Date getAbon() {
        //DateFormat d;
        return abon;
    }

    public Cultivo getCult() {
        return cult;
    }


}
