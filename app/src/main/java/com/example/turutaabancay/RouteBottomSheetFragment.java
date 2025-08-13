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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_route_bottom_sheet_fragment, container, false);

        for (int i = 1; i <= 10; i++) {
            int buttonId = getResources().getIdentifier("button" + i, "id", requireContext().getPackageName());
            Button routeButton = view.findViewById(buttonId);

            if (routeButton != null) {
                int finalI = i;
                routeButton.setOnClickListener(v -> {
                    if (getActivity() instanceof ActividadPrincipal) {
                        ActividadPrincipal main = (ActividadPrincipal) getActivity();

                        LatLng origen, destino;
                        switch (finalI) {
                            case 1:
                                origen = new LatLng(-13.6345, -72.8814);
                                destino = new LatLng(-13.6370, -72.8800);
                                break;
                            case 2:
                                origen = new LatLng(-13.6350, -72.8845);
                                destino = new LatLng(-13.6395, -72.8820);
                                break;
                            default:
                                origen = new LatLng(-13.6345, -72.8814);
                                destino = new LatLng(-13.6370, -72.8800);
                                break;
                        }

                        DirectionsHelper.drawRoute(
                                main.getMap(),
                                origen,
                                destino,
                                "AIzaSyCBkBgFRxvQl_EB6O4Mz_0YIuVpStSCekg"
                        );
                    }
                    dismiss();
                });
            }
        }

        return view;
    }
}