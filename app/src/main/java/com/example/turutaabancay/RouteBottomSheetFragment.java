package com.example.turutaabancay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.gms.maps.model.LatLng;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class RouteBottomSheetFragment extends BottomSheetDialogFragment {
    private static final String API_KEY = "AIzaSyCBkBgFRxvQl_EB6O4Mz_0YIuVpStSCekg"; // Reemplaza con tu API Key

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_route_bottom_sheet_fragment, container, false);

        // Iterar sobre los 10 botones
        for (int i = 1; i <= 10; i++) {
            int buttonId = getResources().getIdentifier("button" + i, "id", requireContext().getPackageName());
            Button routeButton = view.findViewById(buttonId);

            if (routeButton != null) {
                int finalI = i;
                routeButton.setOnClickListener(v -> {
                    if (getActivity() instanceof ActividadPrincipal) {
                        ActividadPrincipal main = (ActividadPrincipal) getActivity();

                        LatLng origen = null, destino = null;
                        List<LatLng> paradas = new ArrayList<>();
                        switch (finalI) {
                            case 1:
                                origen = new LatLng(-13.656361, -72.912620);
                                destino = new LatLng(-13.634406, -72.865322);

                                paradas.add(new LatLng(-13.650934, -72.916268));
                                paradas.add(new LatLng(-13.634532, -72.885980));
                                paradas.add(new LatLng(-13.635733, -72.873263));
                                paradas.add(new LatLng(-13.636086, -72.874262));
                                paradas.add(new LatLng(-13.637293, -72.874184));

                                break;

                            case 2:
                                origen = new LatLng(-13.650935, -72.902341);
                                destino = new LatLng(-13.598274, -72.860846);

                                paradas.add(new LatLng(-13.642507, -72.896271));
                                paradas.add(new LatLng(-13.643096, -72.895230));
                                paradas.add(new LatLng(-13.638016, -72.892067));
                                paradas.add(new LatLng(-13.638016, -72.889556));
                                paradas.add(new LatLng(-13.636520, -72.890580));
                                paradas.add(new LatLng(-13.636372, -72.888456));

                                paradas.add(new LatLng(-13.634730, -72.889505));
                                paradas.add(new LatLng(-13.635554, -72.876808));
                                paradas.add(new LatLng(-13.634424, -72.876588));
                                paradas.add(new LatLng(-13.632355, -72.881255));
                                paradas.add(new LatLng(-13.629733, -72.873274));
                                paradas.add(new LatLng(-13.624819, -72.879065));
                                paradas.add(new LatLng(-13.624119, -72.873055));
                                paradas.add(new LatLng(-13.612712, -72.868099));
                                paradas.add(new LatLng(-13.611660, -72.869296));
                                break;

                            case 3:
                                origen = new LatLng(-13.644867, -72.892688);
                                destino = new LatLng(-13.616846, -72.866075);

                                paradas.add(new LatLng(-13.644312, -72.892333));
                                paradas.add(new LatLng(-13.640266, -72.888918));
                                paradas.add(new LatLng(-13.640766, -72.888449));
                                paradas.add(new LatLng(-13.643088, -72.887264));
                                paradas.add(new LatLng(-13.641721, -72.884767));
                                paradas.add(new LatLng(-13.640821, -72.882323));
                                paradas.add(new LatLng(-13.638099, -72.883203));
                                paradas.add(new LatLng(-13.636574, -72.881481));
                                paradas.add(new LatLng(-13.637145, -72.877047));
                                paradas.add(new LatLng(-13.636351, -72.876945));
                                paradas.add(new LatLng(-13.634392, -72.883720));
                                paradas.add(new LatLng(-13.634566, -72.886789));
                                paradas.add(new LatLng(-13.632676, -72.887816));
                                paradas.add(new LatLng(-13.630602, -72.884708));
                                paradas.add(new LatLng(-13.630611, -72.886670));
                                paradas.add(new LatLng(-13.628677, -72.888402));
                                paradas.add(new LatLng(-13.628274, -72.881541));
                                paradas.add(new LatLng(-13.626981, -72.885335));
                                paradas.add(new LatLng(-13.626586, -72.878198));
                                break;

                            case 4:
                                origen = new LatLng(-13.652149, -72.899287);
                                destino = new LatLng(-13.620412, -72.861509);

                                paradas.add(new LatLng(-13.643394, -72.896639)); // Cruce importante
                                paradas.add(new LatLng(-13.638237, -72.884724)); // Tramo medio
                                paradas.add(new LatLng(-13.639285, -72.878706)); // Desvío clave
                                paradas.add(new LatLng(-13.635566, -72.876835)); // Curva importante
                                break;

                            case 5:
                                origen = new LatLng(-13.6355, -72.8850);
                                destino = new LatLng(-13.6390, -72.8825);
                                paradas.add(new LatLng(-13.6360, -72.8840));
                                break;

                            case 6:
                                origen = new LatLng(-13.6345, -72.8800);
                                destino = new LatLng(-13.6385, -72.8780);
                                paradas.add(new LatLng(-13.6355, -72.8790));
                                break;

                            case 7:
                                origen = new LatLng(-13.6350, -72.8825);
                                destino = new LatLng(-13.6390, -72.8795);
                                paradas.add(new LatLng(-13.6360, -72.8815));
                                break;

                            case 8:
                                origen = new LatLng(-13.6340, -72.8840);
                                destino = new LatLng(-13.6370, -72.8815);
                                paradas.add(new LatLng(-13.6350, -72.8825));
                                break;

                            case 9:
                                origen = new LatLng(-13.6355, -72.8830);
                                destino = new LatLng(-13.6380, -72.8805);
                                paradas.add(new LatLng(-13.6360, -72.8815));
                                break;

                            case 10:
                                origen = new LatLng(-13.6345, -72.8825);
                                destino = new LatLng(-13.6375, -72.8795);
                                paradas.add(new LatLng(-13.6355, -72.8815));
                                break;
                        }

                        // Dibuja la ruta usando Google Directions con paradas intermedias
                        DirectionsHelper.drawRouteWithWaypoints(
                                main.getMap(),
                                origen,
                                destino,
                                paradas,
                                API_KEY,
                                0xFF2196F3
                        );
                    }

                    dismiss();
                });
            }
        }

        return view;
    }
}