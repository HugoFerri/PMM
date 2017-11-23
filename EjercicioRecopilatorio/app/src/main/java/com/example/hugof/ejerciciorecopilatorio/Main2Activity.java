package com.example.hugof.ejerciciorecopilatorio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Pais pais;
    TextView nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        TextView tar = findViewById(R.id.TVtarifa);
        TextView dec = findViewById(R.id.TVdecoracion);
        TextView peso = findViewById(R.id.TVpeso);
        TextView coste = findViewById(R.id.TVcoste);
        ImageView img = findViewById(R.id.imageView);
        nom = findViewById(R.id.TVzona);

        pais = (Pais)bundle.getSerializable("PAIS");

        nom.setText(pais.getZona()+" : " +pais.getNombre());
        dec.setText(bundle.getString("ADICIONAL"));
        tar.setText(bundle.getString("TARIFA"));
        peso.setText(bundle.getString("PESO"));
        coste.setText(bundle.getString("PRECIO"));
        img.setImageResource(pais.getFoto());

        registerForContextMenu(img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.showContextMenu();
            }  });

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        menu.setHeaderTitle(pais.getNombre());
        inflater.inflate(R.menu.contextual_menu, menu);
    }
    public boolean onContextItemSelected(MenuItem itemMnuContex) {
        nom=findViewById(R.id.TVzona);
        switch (itemMnuContex.getItemId()) {
            case R.id.Pais1:
                if (pais.getNombre().equalsIgnoreCase("America")){
                    nom.setText("America");
                    Intent intent1= new Intent(Main2Activity.this,Asia.class);
                    startActivity(intent1);
                }

            case R.id.Pais2:
                if (pais.getNombre().equalsIgnoreCase("Asia y oceania")){
                    nom.setText("Asia y oceania");
                    Intent intent2= new Intent(Main2Activity.this,America.class);
                    startActivity(intent2);
                }

            case R.id.Pais3:
                if (pais.getNombre().equalsIgnoreCase("Europa")){
                    nom.setText("Europa");
                    Intent intent3= new Intent(Main2Activity.this,Europe.class);
                    startActivity(intent3);
                }

            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }
}