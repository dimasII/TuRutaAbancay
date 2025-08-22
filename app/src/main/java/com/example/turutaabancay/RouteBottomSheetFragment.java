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
                            paradasBajada.add(new LatLng(-13.634464, -72.868781));
                            paradasBajada.add(new LatLng(-13.633887, -72.869862));
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
                            paradasSubida.add(new LatLng(-13.638016, -72.889556));
                            paradasSubida.add(new LatLng(-13.636520, -72.890580));
                            paradasSubida.add(new LatLng(-13.636372, -72.888456));

                            paradasSubida.add(new LatLng(-13.634730, -72.889505));
                            paradasSubida.add(new LatLng(-13.635554, -72.876808));
                            paradasSubida.add(new LatLng(-13.634424, -72.876588));
                            paradasSubida.add(new LatLng(-13.632355, -72.881255));
                            paradasSubida.add(new LatLng(-13.629733, -72.873274));
                            paradasSubida.add(new LatLng(-13.624819, -72.879065));
                            paradasSubida.add(new LatLng(-13.624119, -72.873055));
                            paradasSubida.add(new LatLng(-13.612712, -72.868099));
                            paradasSubida.add(new LatLng(-13.611660, -72.869296));

                            origenBajada = destinoSubida;
                            destinoBajada = origenSubida;

                            paradasBajada.add(new LatLng(-13.624093, -72.873012));
                            paradasBajada.add(new LatLng(-13.624795, -72.879085));
                            paradasBajada.add(new LatLng(-13.629766, -72.873278));
                            paradasBajada.add(new LatLng(-13.632387, -72.881217));
                            paradasBajada.add(new LatLng(-13.634391, -72.876582));
                            paradasBajada.add(new LatLng(-13.636341, -72.876911));
                            paradasBajada.add(new LatLng(-13.635337, -72.884461));
                            paradasBajada.add(new LatLng(-13.634783, -72.889465));
                            paradasBajada.add(new LatLng(-13.636394, -72.888471));
                            paradasBajada.add(new LatLng(-13.636673, -72.890684));
                            paradasBajada.add(new LatLng(-13.638066, -72.889582));
                            paradasBajada.add(new LatLng(-13.638158, -72.892088));
                            paradasBajada.add(new LatLng(-13.640206, -72.891657));
                            paradasBajada.add(new LatLng(-13.643075, -72.895219));
                            paradasBajada.add(new LatLng(-13.642478, -72.896557));
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

                        case 4:
                            origenSubida = new LatLng(-13.652149, -72.899235);
                            destinoSubida = new LatLng(-13.620568, -72.861578);
                            paradasSubida.add(new LatLng(-13.638008, -72.892024));
                            paradasSubida.add(new LatLng(-13.637906, -72.883384));
                            /*paradasSubida.add(new LatLng());
                            paradasSubida.add(new LatLng());
                            paradasSubida.add(new LatLng());
                            paradasSubida.add(new LatLng());
                            paradasSubida.add(new LatLng());
                            paradasSubida.add(new LatLng());
                            paradasSubida.add(new LatLng());
                            paradasSubida.add(new LatLng());
                            paradasSubida.add(new LatLng());
                            paradasSubida.add(new LatLng());*/
                            break;
                        case 5:
                            break;
                        case 6:
                            origenSubida = new LatLng(-13.634462, -72.901965);
                            destinoSubida = new LatLng(-13.608771, -72.855062);

                            paradasSubida.add(new LatLng(-13.636306, -72.898382));
                            paradasSubida.add(new LatLng(-13.633789, -72.896256));
                            paradasSubida.add(new LatLng(-13.633807, -72.890691));
                            paradasSubida.add(new LatLng(-13.634747, -72.889903));
                            paradasSubida.add(new LatLng(-13.634701, -72.883596));
                            paradasSubida.add(new LatLng(-13.635537, -72.876815));
                            paradasSubida.add(new LatLng(-13.632231, -72.881181));
                            paradasSubida.add(new LatLng(-13.631508, -72.878908));
                            paradasSubida.add(new LatLng(-13.629704, -72.873286));
                            paradasSubida.add(new LatLng(-13.627738, -72.875385));
                            paradasSubida.add(new LatLng(-13.626833, -72.873901));
                            paradasSubida.add(new LatLng(-13.625170, -72.873026));
                            paradasSubida.add(new LatLng(-13.622995, -72.869735));
                            paradasSubida.add(new LatLng(-13.620926, -72.870024));
                            paradasSubida.add(new LatLng(-13.615268, -72.863591));

                            origenBajada = destinoSubida;
                            destinoBajada = origenSubida;
                            paradasBajada.add(new LatLng(-13.623341, -72.871801));
                            paradasBajada.add(new LatLng(-13.623251, -72.869915));
                            paradasBajada.add(new LatLng(-13.625175, -72.873018));
                            paradasBajada.add(new LatLng(-13.630503, -72.875261));
                            paradasBajada.add(new LatLng(-13.632382, -72.881220));
                            paradasBajada.add(new LatLng(-13.634448, -72.876590));
                            paradasBajada.add(new LatLng(-13.636336, -72.876918));
                            paradasBajada.add(new LatLng(-13.635370, -72.884441));
                            paradasBajada.add(new LatLng(-13.633181, -72.887909));
                            paradasBajada.add(new LatLng(-13.632726, -72.889884));
                            break;
                        case 7:
                            origenSubida = new LatLng(-13.635748, -72.910633);
                            destinoSubida = new LatLng(-13.650300, -72.851589);
                            paradasSubida.add(new LatLng(-13.634445, -72.901979));
                            paradasSubida.add(new LatLng(-13.635087, -72.899256));
                            paradasSubida.add(new LatLng(-13.632857, -72.893933));
                            paradasSubida.add(new LatLng(-13.633303, -72.895317));
                            paradasSubida.add(new LatLng(-13.635104, -72.893684));
                            paradasSubida.add(new LatLng(-13.632965, -72.890868));
                            paradasSubida.add(new LatLng(-13.632748, -72.890233));
                            paradasSubida.add(new LatLng(-13.634772, -72.889882));
                            paradasSubida.add(new LatLng(-13.634431, -72.883730));
                            paradasSubida.add(new LatLng(-13.635708, -72.884604));
                            paradasSubida.add(new LatLng(-13.636334, -72.877001));
                            paradasSubida.add(new LatLng(-13.636123, -72.876855));

                            origenBajada = destinoSubida;
                            destinoBajada = origenSubida;
                            paradasBajada.add(new LatLng(-13.635417, -72.884457));
                            paradasBajada.add(new LatLng(-13.634741, -72.889872));
                            paradasBajada.add(new LatLng(-13.633771, -72.890637));
                            paradasBajada.add(new LatLng(-13.634511, -72.893042));
                            paradasBajada.add(new LatLng(-13.633318, -72.895316));
                            paradasBajada.add(new LatLng(-13.631676, -72.895088));
                            paradasBajada.add(new LatLng(-13.634456, -72.901940));
                            break;
                        case 8:
                            origenSubida = new LatLng(-13.628402, -72.900538);
                            destinoSubida = new LatLng(-13.622162, -72.873744);
                            paradasSubida.add(new LatLng(-13.626593, -72.880968));
                            paradasSubida.add(new LatLng(-13.628329, -72.880319));
                            paradasSubida.add(new LatLng(-13.628706, -72.885907));
                            paradasSubida.add(new LatLng(-13.632688, -72.885962));
                            paradasSubida.add(new LatLng(-13.634732, -72.889894));
                            paradasSubida.add(new LatLng(-13.635017, -72.882717));
                            paradasSubida.add(new LatLng(-13.636127, -72.883092));
                            paradasSubida.add(new LatLng(-13.637147, -72.877032));
                            paradasSubida.add(new LatLng(-13.636277, -72.877947));
                            paradasSubida.add(new LatLng(-13.633859, -72.877675));
                            paradasSubida.add(new LatLng(-13.632345, -72.881220));
                            paradasSubida.add(new LatLng(-13.631077, -72.877237));
                            paradasSubida.add(new LatLng(-13.622300, -72.885865));
                            paradasSubida.add(new LatLng(-13.618210, -72.881584));

                            origenBajada = destinoSubida;
                            destinoBajada = origenSubida;
                            paradasBajada.add(new LatLng(-13.618310, -72.881573));
                            paradasBajada.add(new LatLng(-13.622405, -72.885828));
                            paradasBajada.add(new LatLng(-13.621498, -72.879764));
                            paradasBajada.add(new LatLng(-13.631054, -72.877245));
                            paradasBajada.add(new LatLng(-13.632338, -72.881189));
                            paradasBajada.add(new LatLng(-13.634453, -72.876596));
                            paradasBajada.add(new LatLng(-13.636338, -72.876944));
                            paradasBajada.add(new LatLng(-13.635394, -72.884475));
                            paradasBajada.add(new LatLng(-13.634564, -72.886753));
                            paradasBajada.add(new LatLng(-13.632688, -72.887830));
                            paradasBajada.add(new LatLng(-13.632654, -72.884683));
                            paradasBajada.add(new LatLng(-13.630593, -72.884693));
                            paradasBajada.add(new LatLng(-13.629353, -72.888046));
                            paradasBajada.add(new LatLng(-13.629596, -72.880433));
                            paradasBajada.add(new LatLng(-13.626548, -72.880964));
                            break;
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