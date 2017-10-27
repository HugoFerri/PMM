package com.example.hugtra.ejerciciolayoutsbotones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button botonLinear = (Button) findViewById(R.id.botonLinear);

        botonLinear.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent1 = new Intent(MainActivity.this, PantallaLinear.class);
                startActivity(miIntent1);
            }
        });

        botonLinear.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent2 = new Intent(MainActivity.this, PantallaTable.class);
                startActivity(miIntent2);
            }
        });
    }
}
