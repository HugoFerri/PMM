package com.example.hugtra.complayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaRelative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_relative);

        final Button botonRelative2 = (Button) findViewById(R.id.botonRelative2);
        final TextView etiquetaRelative2 = (TextView) findViewById(R.id.etiquetaRelative2);

        botonRelative2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                etiquetaRelative2.setText("HAS CLICKADO");
            }
        });

    }
}
