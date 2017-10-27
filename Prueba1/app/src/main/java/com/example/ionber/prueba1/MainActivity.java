package com.example.ionber.prueba1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);

        miTexto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                String borrado = " ";
                miTexto.setText(borrado);
            }

        });
        final Button miBoton = (Button) findViewById(R.id.BotonSaludo);
        final TextView elSaludo = (TextView) findViewById(R.id.miLbl);

        Toast.makeText(this, "Estoy en la pantalla 1", Toast.LENGTH_SHORT).show();


        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);

                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();

                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);

                startActivity(miIntent);
            }
        });

    }

}
