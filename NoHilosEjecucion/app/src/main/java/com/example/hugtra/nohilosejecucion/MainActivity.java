package com.example.hugtra.nohilosejecucion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    private EditText entrada;
    private TextView salida;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.entrada);
        entrada = (EditText) findViewById(R.id.salida);
    }

    public void calcularOperacion (View view){
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + ());
    }
}
