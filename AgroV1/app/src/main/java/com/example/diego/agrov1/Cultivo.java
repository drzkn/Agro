package com.example.diego.agrov1;

/**
 * Created by diego on 15/03/2017.
 */

public class Cultivo {

    private String id;
    private String name;
    private float waterneed;

    public Cultivo(String id, String name, float waterneed) {

        this.id = id;
        this.name = name;
        this.waterneed = waterneed;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getWaterneed() {
        return waterneed;
    }

    @Override
    public String toString() {
        return "De " + name;
    }
}
