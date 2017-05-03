package com.example.diego.agrov1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class MapActivity extends AppCompatActivity {

    private MapView mapView = null;
    private MapboxMap mapboxMap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapboxAccountManager.start(this, getString(R.string.access_token));

        setContentView(R.layout.activity_map);

        mapView = (MapView)findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap map) {

                Explotacion objeto = (Explotacion)getIntent().getExtras().getSerializable("parametro");
                LatLng latlng = new LatLng(objeto.getLat(),objeto.getLon());
                mapboxMap = map;

                //mapboxMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-1.61239, 42.78921), 10));
                mapboxMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 10));

                mapboxMap.addMarker(new MarkerOptions()
                        //.position(new LatLng(48.13863, 11.57603))
                        .position(latlng)
                        //.title("Hello World!")
                        .title(objeto.getName())
                        //.snippet("Welcome to my marker."));
                        .snippet("Explotacion de "+objeto.getCult()));



            }
        });



    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public void toUpdate (View view){

        Intent intent = new Intent(this, UpdateActivity.class);

        Explotacion objeto = (Explotacion)getIntent().getExtras().getSerializable("parametro");
        intent.putExtra("parametro", objeto);

        startActivity(intent);
        finish();

    }
}
