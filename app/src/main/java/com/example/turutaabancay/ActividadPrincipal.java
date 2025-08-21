package com.example.turutaabancay;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;

public class ActividadPrincipal extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap gMap;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";
    private Spinner spinnerRutas;
    private LinearLayout layoutLeyenda;
    private LatLng oSub, dSub, oBaj, dBaj;
    private List<LatLng> wSub, wBaj;
    private String apiKeyLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);

        // MapView
        mapView = findViewById(R.id.mapView);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);

        // Spinner superior (menú principal)
        Spinner spinner2 = findViewById(R.id.spinner2);
        String[] options = {"Seleccione", "Rutas", "Otra opción"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) { // Rutas
                    showRouteBottomSheet();
                    spinner2.setSelection(0); // Volver a "Seleccione"
                }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Spinner de sentido (oculto inicialmente)
        spinnerRutas = findViewById(R.id.spinnerRutas);
        spinnerRutas.setVisibility(View.GONE);

        // Leyenda (oculta inicialmente)
        layoutLeyenda = findViewById(R.id.layoutLeyenda);
        layoutLeyenda.setVisibility(View.GONE);
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

    public void mostrarSpinnerSentido(LatLng origenSubida, LatLng destinoSubida, List<LatLng> paradasSubida,
                                      LatLng origenBajada, LatLng destinoBajada, List<LatLng> paradasBajada,
                                      String apiKey, RouteBottomSheetFragment sheet) {
        // ✅ Cerramos el BottomSheet automáticamente
        if (sheet != null) {
            sheet.dismiss();
        }

        // Guardamos datos
        this.oSub = origenSubida;
        this.dSub = destinoSubida;
        this.wSub = paradasSubida;
        this.oBaj = origenBajada;
        this.dBaj = destinoBajada;
        this.wBaj = paradasBajada;
        this.apiKeyLocal = apiKey;

        // Configurar spinner
        String[] opciones = {"Ambos", "Bajada", "Subida"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, opciones
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRutas.setAdapter(adapter);

        // Mostrar spinner
        spinnerRutas.setVisibility(View.VISIBLE);

        spinnerRutas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (gMap == null) return;
                DirectionsHelper.clearRoutes();

                String sel = opciones[position];
                if ("Subida".equals(sel)) {
                    layoutLeyenda.setVisibility(View.GONE); // 👈 Ocultamos leyenda
                    DirectionsHelper.drawRouteWithWaypoints(
                            gMap, oSub, dSub, wSub, apiKeyLocal, 0xFF2196F3 // azul
                    );
                } else if ("Bajada".equals(sel)) {
                    layoutLeyenda.setVisibility(View.GONE); // 👈 Ocultamos leyenda
                    DirectionsHelper.drawRouteWithWaypoints(
                            gMap, oBaj, dBaj, wBaj, apiKeyLocal, 0xFFE91E63 // rosado
                    );
                } else { // Ambos
                    layoutLeyenda.setVisibility(View.VISIBLE); // 👈 Mostramos leyenda
                    DirectionsHelper.drawRouteWithWaypoints(
                            gMap, oSub, dSub, wSub, apiKeyLocal, 0xFF2196F3
                    );
                    DirectionsHelper.drawRouteWithWaypoints(
                            gMap, oBaj, dBaj, wBaj, apiKeyLocal, 0xFFE91E63
                    );
                }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerRutas.setSelection(0); // Selección inicial: Ambos
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

    public GoogleMap getMap() { return gMap; }
}