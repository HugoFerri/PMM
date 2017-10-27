package com.example.hugtra.complayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_table);

        final Button botonTable2 = (Button) findViewById(R.id.botonTable2);
        final TextView etiquetaTable2 = (TextView) findViewById(R.id.etiquetaTable2);

        botonTable2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                etiquetaTable2.setText("HAS CLICKADO");
            }
        });
    }
}
