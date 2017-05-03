package com.example.diego.agrov1;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;

/**
 * Created by diego on 05/04/2017.
 */

public class ParseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.v("Parse11Application", "onCreateCalled");

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("agrov1") //si no has cambiado APP_ID, sino pon el valor de APP_ID
                .clientKey("empty")
                .server("https://agro-2017.herokuapp.com/parse/")   // '/' important after 'parse'
                .build());

    }

}
