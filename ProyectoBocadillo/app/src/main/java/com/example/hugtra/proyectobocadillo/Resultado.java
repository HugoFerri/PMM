package com.example.hugtra.proyectobocadillo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    private Bocadillo bocadillo;
    TextView nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle bundle = getIntent().getExtras();

        TextView extras = (TextView)findViewById(R.id.TVextra);
        TextView Envio = (TextView)findViewById(R.id.TVEnvio);
        TextView cantidad = (TextView)findViewById(R.id.TVunidades);
        TextView coste = (TextView)findViewById(R.id.TVcoste);
        TextView preciobase = (TextView)findViewById(R.id.TVprecio);
        ImageView img = (ImageView)findViewById(R.id.imageView);

        nom =(TextView)findViewById(R.id.TVbocadillo);
        bocadillo = (Bocadillo)bundle.getSerializable("BOCADILLO");
        String a = Integer.toString(bocadillo.getPrecio());
        nom.setText(bocadillo.getNombre());
        preciobase.setText(a);
        extras.setText(bundle.getString("EXTRAS"));
        cantidad.setText(bundle.getString("CANTIDAD"));
        Envio.setText(bundle.getString("ENVIO"));
        coste.setText(bundle.getString("TOTAL"));
        img.setImageResource(bocadillo.getFoto());



    }
}