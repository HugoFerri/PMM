package com.example.hugtra.listacontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final TextView texto1 = (TextView) findViewById(R.id.texto1);
        final String[] datos = new String[]{"Lunes","Martes","Miercoles","Jueves","Viernes"};
        ArrayAdapter<String> adaptador = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, datos);

        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);


        final Spinner cmbOpciones = (Spinner)findViewById(R.id.spinner1);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);

    }
}
