package com.example.turutaabancay;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class ActividadPrincipal extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap gMap;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);

        // Inicializar MapView
        mapView = findViewById(R.id.mapView);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);

        // Configurar Spinner
        Spinner spinner2 = findViewById(R.id.spinner2);
        String[] options = {"Seleccione", "Rutas", "Otra opción"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) { // Rutas
                    showRouteBottomSheet();
                    spinner2.setSelection(0); // Volver a "Seleccione"
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        LatLng abancay = new LatLng(-13.635, -72.881);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(abancay, 14));
        gMap.addMarker(new MarkerOptions().position(abancay).title("Abancay"));
    }

    private void showRouteBottomSheet() {
        RouteBottomSheetFragment bottomSheet = new RouteBottomSheetFragment();
        bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
    }

    private void dibujarRuta(int rutaId) {
        if (gMap == null) return;

        gMap.clear();
        List<LatLng> puntos = new ArrayList<>();

        switch (rutaId) {
            case 1:
                puntos.add(new LatLng(-13.656249, -72.910968));
                puntos.add(new LatLng(-13.6351, -72.8815));
                puntos.add(new LatLng(-13.6330, -72.8780));
                break;
            case 2:
                puntos.add(new LatLng(-13.6370, -72.8850));
                puntos.add(new LatLng(-13.6345, -72.8825));
                puntos.add(new LatLng(-13.6310, -72.8800));
                break;
        }

        if (!puntos.isEmpty()) {
            gMap.addPolyline(new PolylineOptions()
                    .addAll(puntos)
                    .width(8)
                    .color(0xFF2196F3));
            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(puntos.get(0), 15));
        }
    }

    @Override protected void onStart() { super.onStart(); mapView.onStart(); }
    @Override protected void onResume() { super.onResume(); mapView.onResume(); }
    @Override protected void onPause() { mapView.onPause(); super.onPause(); }
    @Override protected void onStop() { mapView.onStop(); super.onStop(); }
    @Override protected void onDestroy() { mapView.onDestroy(); super.onDestroy(); }
    @Override public void onLowMemory() { super.onLowMemory(); mapView.onLowMemory(); }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }
        mapView.onSaveInstanceState(mapViewBundle);
    }

    // ✅ Ahora devuelve el GoogleMap real
    public GoogleMap getMap() {
        return gMap;
    }
}