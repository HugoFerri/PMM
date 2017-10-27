package com.example.hugtra.complayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaLinear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_linear);

        final Button botonLinear2 = (Button) findViewById(R.id.botonLinear2);
        final TextView etiquetaLinear2 = (TextView) findViewById(R.id.etiquetaLinear2);

        botonLinear2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                etiquetaLinear2.setText("HAS CLICKADO");
            }
        });

    }
}
