package com.example.jdarestaurant_mvvm.ui.nueva_reserva;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jdarestaurant_mvvm.R;

public class NuevaReservaFragment extends Fragment {

    private NuevaReservaViewModel mViewModel;
    private EditText fecha, comensales, comentarios, nombre, telefono;
    private Button enviar_reserva;

    public static NuevaReservaFragment newInstance() {
        return new NuevaReservaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(NuevaReservaViewModel.class);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hacer_reserva, container, false);

        fecha = view.findViewById(R.id.fechaEditText);
        comensales = view.findViewById(R.id.comensalesEditText);
        comentarios = view.findViewById(R.id.comentariosEditText);
        nombre = view.findViewById(R.id.nombreEditText);
        telefono = view.findViewById(R.id.telefonoEditText);
        enviar_reserva = view.findViewById(R.id.reservaButton);

        enviar_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mViewModel.reservar(getContext(),fecha.getText().toString(),Integer.parseInt(comensales.getText().toString()),
                            nombre.getText().toString(),telefono.getText().toString(),comentarios.getText().toString());
                    Toast.makeText(getContext(), "reserva registrada", Toast.LENGTH_LONG);
                } catch (Exception e) {
                    Toast.makeText(getContext(), "numero personas debe ser un numero", Toast.LENGTH_LONG);
                }
            }
        });

        return view;
    }

}
