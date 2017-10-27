package com.example.hugtra.diferenteseventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context ctx=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx=this;

        setContentView(R.layout.activity_main);

        Button btn=(Button)this.findViewById(R.id.cmdTres);
        btn.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Pulsado boton Tres", Toast.LENGTH_SHORT).show();

            }}
        );
    }

    public void cmdDos_click(View v){
        Toast.makeText(this, "Pulsado bot�n Dos", Toast.LENGTH_SHORT).show();
    }
}
