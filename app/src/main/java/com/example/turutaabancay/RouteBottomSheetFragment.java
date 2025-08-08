package com.example.turutaabancay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class RouteBottomSheetFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_route_bottom_sheet_fragment, container, false);

        TextView locationText = view.findViewById(R.id.location_text);
        locationText.setText("Mi ubicación actual: Av. Núñez / Jr. Lima"); // Cambia esto según sea necesario

        // Configurar los botones
        for (int i = 1; i <= 8; i++) {
            int buttonId = getResources().getIdentifier("button" + i, "id", getContext().getPackageName());
            Button routeButton = view.findViewById(buttonId);
            routeButton.setOnClickListener(v -> {
                // Aquí puedes agregar la lógica para mostrar la ruta seleccionada
                // Por ejemplo, abrir otra actividad o fragmento
                // Puedes usar `i` para identificar qué botón fue presionado
            });
        }

        Button ajustesButton = view.findViewById(R.id.ajustes_button);
        ajustesButton.setOnClickListener(v -> {
            // Lógica para el botón de ajustes
        });

        return view;
    }
}