package com.example.hugtra.paso_objetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    Campeon campeon_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Bundle recibir_datos=getIntent().getExtras();
        TextView nombre = (TextView)findViewById(R.id.textView);
        TextView tipo = (TextView)findViewById(R.id.textView2);
        TextView precio = (TextView)findViewById(R.id.textView3);
        ImageView img = (ImageView)findViewById(R.id.imageView);

        campeon_helper=(Campeon)recibir_datos.getSerializable("Campeon");


        nombre.setText(campeon_helper.getNombre());
        tipo.setText(campeon_helper.getTipo());
        String help = Integer.toString(campeon_helper.getPrecio());
        precio.setText(help);
        img.setImageResource(campeon_helper.getFoto());
    }
}
