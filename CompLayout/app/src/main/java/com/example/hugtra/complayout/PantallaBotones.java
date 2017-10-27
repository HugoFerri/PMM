package com.example.hugtra.complayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class PantallaBotones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_botones);

        final TextView lblMensaje = (TextView)findViewById(R.id.LblMensaje);
        final Button btnBoton1 = (Button)findViewById(R.id.BtnBoton1);
        final ToggleButton btnBoton2 = (ToggleButton)findViewById(R.id.BtnBoton2);
        final ImageButton btnBoton3 = (ImageButton)findViewById(R.id.BtnBoton3);
        final ToggleButton btnBoton4 = (ToggleButton)findViewById(R.id.BtnBoton4);

        btnBoton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                lblMensaje.setText("Botón 1 pulsado!");
            }
        });

        btnBoton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(btnBoton2.isChecked())
                    lblMensaje.setText("Botón 2: ON");
                else
                    lblMensaje.setText("Botón 2: OFF");
            }
        });

        btnBoton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                lblMensaje.setText("Botón 3 pulsado!");
            }
        });

        btnBoton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (btnBoton4.isChecked())
                    lblMensaje.setText("Botón 4: ON");
                else
                    lblMensaje.setText("Botón 4: OFF");
            }
        });
    }
}
