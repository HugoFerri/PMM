package com.example.hugtra.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button btnPreferencias;
    private Button btnObtenerPreferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPreferencias = (Button)findViewById(R.id.btnPreferencias);
        btnObtenerPreferencias = (Button)findViewById(R.id.btnObtenerPreferencias);

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PantallaOpciones.class));
            }
        });

        btnObtenerPreferencias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String preferen1 = "desactivada";
                if(pref.getBoolean("opcion 1", false)) preferen1 = "activada";
                Toast.makeText(getApplicationContext(), preferen1, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), pref.getString("Opcion 2", ""), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), pref.getString("Opcion 3", ""), Toast.LENGTH_SHORT).show();
            } });
    }
}