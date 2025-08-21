package com.example.turutaabancay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class RouteBottomSheetFragment extends BottomSheetDialogFragment {
    private static final String API_KEY = "AIzaSyCBkBgFRxvQl_EB6O4Mz_0YIuVpStSCekg";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_route_bottom_sheet_fragment, container, false);
        for (int i = 1; i <= 10; i++) {
            int buttonId = getResources().getIdentifier("button" + i, "id", requireContext().getPackageName());
            View routeButton = view.findViewById(buttonId);

            if (routeButton != null) {
                int finalI = i;
                routeButton.setOnClickListener(v -> {
                    if (!(getActivity() instanceof ActividadPrincipal)) return;
                    ActividadPrincipal main = (ActividadPrincipal) getActivity();

                    // Rutas de SUBIDA y BAJADA
                    LatLng origenSubida = null, destinoSubida = null;
                    List<LatLng> paradasSubida = new ArrayList<>();

                    LatLng origenBajada = null, destinoBajada = null;
                    List<LatLng> paradasBajada = new ArrayList<>();

                    switch (finalI) {
                        case 1:
                            // SUBIDA
                            origenSubida = new LatLng(-13.656361, -72.912620);
                            destinoSubida = new LatLng(-13.634406, -72.865322);
                            paradasSubida.add(new LatLng(-13.650934, -72.916268));
                            paradasSubida.add(new LatLng(-13.634532, -72.885980));
                            paradasSubida.add(new LatLng(-13.635733, -72.873263));

                            // BAJADA
                            origenBajada = destinoSubida;
                            destinoBajada = origenSubida;
                            paradasBajada.add(new LatLng(-13.634944, -72.871345));
                            paradasBajada.add(new LatLng(-13.636144, -72.872043));
                            paradasBajada.add(new LatLng(-13.635328, -72.872603));
                            paradasBajada.add(new LatLng(-13.635387, -72.884456));
                            break;

                        case 2:
                            origenSubida = new LatLng(-13.650935, -72.902341);
                            destinoSubida = new LatLng(-13.598274, -72.860846);
                            paradasSubida.add(new LatLng(-13.642507, -72.896271));
                            paradasSubida.add(new LatLng(-13.643096, -72.895230));
                            paradasSubida.add(new LatLng(-13.638016, -72.892067));

                            origenBajada = destinoSubida;
                            destinoBajada = origenSubida;
                            paradasBajada.addAll(paradasSubida);
                            break;

                        case 3:
                            origenSubida = new LatLng(-13.644867, -72.892688);
                            destinoSubida = new LatLng(-13.616846, -72.866075);

                            paradasSubida.add(new LatLng(-13.640370, -72.888718));
                            paradasSubida.add(new LatLng(-13.640775, -72.888433));
                            paradasSubida.add(new LatLng(-13.643090, -72.887263));
                            paradasSubida.add(new LatLng(-13.641042, -72.885145));
                            paradasSubida.add(new LatLng(-13.640485, -72.884437));
                            paradasSubida.add(new LatLng(-13.640009, -72.882493));
                            paradasSubida.add(new LatLng(-13.638066, -72.883191));
                            paradasSubida.add(new LatLng(-13.636564, -72.881498));
                            paradasSubida.add(new LatLng(-13.636336, -72.876929));
                            paradasSubida.add(new LatLng(-13.635394, -72.884469));
                            paradasSubida.add(new LatLng(-13.634561, -72.886773));
                            paradasSubida.add(new LatLng(-13.632680, -72.887837));
                            paradasSubida.add(new LatLng(-13.632606, -72.884675));
                            paradasSubida.add(new LatLng(-13.630624, -72.884684));
                            paradasSubida.add(new LatLng(-13.628702, -72.888292));
                            paradasSubida.add(new LatLng(-13.628279, -72.881544));
                            paradasSubida.add(new LatLng(-13.626753, -72.882023));
                            paradasSubida.add(new LatLng(-13.626977, -72.885311));
                            paradasSubida.add(new LatLng(-13.626560, -72.878193));

                            origenBajada = destinoSubida;
                            destinoBajada = origenSubida;
                            paradasBajada.add(new LatLng(-13.625613, -72.877954));
                            paradasBajada.add(new LatLng(-13.627009, -72.885930));
                            paradasBajada.add(new LatLng(-13.632727, -72.890196));
                            paradasBajada.add(new LatLng(-13.634717, -72.888975));
                            paradasBajada.add(new LatLng(-13.635574, -72.876800));
                            paradasBajada.add(new LatLng(-13.636396, -72.879772));
                            paradasBajada.add(new LatLng(-13.638117, -72.883201));
                            paradasBajada.add(new LatLng(-13.640837, -72.882336));
                            paradasBajada.add(new LatLng(-13.640869, -72.884027));
                            paradasBajada.add(new LatLng(-13.641754, -72.884747));
                            paradasBajada.add(new LatLng(-13.640314, -72.888912));


                            break;

                        // TODO: Agrega casos 4..10 según tus datos
                    }
                    main.mostrarSpinnerSentido(
                            origenSubida, destinoSubida, paradasSubida,
                            origenBajada, destinoBajada, paradasBajada,
                            API_KEY,
                            this
                    );
                });
            }
        }
        return view;
    }
}