package com.example.diego.agrov1;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util

/**
 * Created by diego on 15/03/2017.
 */

@SuppressWarnings("serial")
public class Explotacion implements Serializable {

    private String id;
    private String name;
    private float ext;
    private float lat;
    private float lon;
    private String abon;
    private String cult;

    @Override
    public String toString() {

        return name + "\n" +
                "Estension " + ext + " hectareas" +
                "\nUltimo abonado\n" + abon +
                "\n" + cult + "\n" ;
    }

    public Explotacion(String id, String name, float ext, float lat, float lon, String abon, String cult) {

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

    public String getAbon() {
        return abon;
    }

    public String getCult() {
        return cult;
    }


}
