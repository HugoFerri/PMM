package com.example.hugtra.complayout;

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
        final Button botonTable = (Button) findViewById(R.id.botonTable);
        final Button botonRelative = (Button) findViewById(R.id.botonRelative);
        final Button botonCheckbox = (Button) findViewById(R.id.botonCheckbox);
        final Button botonRadioButton = (Button) findViewById(R.id.botonRadioButton);
        final Button botonBotones = (Button) findViewById(R.id.botonBotones);


        botonLinear.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent1 = new Intent(MainActivity.this, PantallaLinear.class);
                startActivity(miIntent1);
            }
        });

        botonRelative.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent2 = new Intent(MainActivity.this, PantallaRelative.class);
                startActivity(miIntent2);
            }
        });

        botonTable.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent3 = new Intent(MainActivity.this, PantallaTable.class);
                startActivity(miIntent3);
            }
        });

        botonCheckbox.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent4 = new Intent(MainActivity.this, PantallaCheckbox.class);
                startActivity(miIntent4);
            }
        });

        botonRadioButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent5 = new Intent(MainActivity.this, PantallaRadioButton.class);
                startActivity(miIntent5);
            }
        });

        botonBotones.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent6 = new Intent(MainActivity.this, PantallaBotones.class);
                startActivity(miIntent6);
            }
        });

    }
}
