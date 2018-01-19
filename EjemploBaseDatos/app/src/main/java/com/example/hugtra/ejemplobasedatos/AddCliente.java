package com.example.hugtra.ejemplobasedatos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cliente);

        Button guardarcliente = findViewById(R.id.crear_nuevo_cliente);

        guardarcliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guardarCliente();
            }
        });
    }

    public void guardarCliente() {
        ClienteSQLite cliBDh = new ClienteSQLite(this, "DBClientes", null, 1);

        SQLiteDatabase bd = cliBDh.getWritableDatabase();
        EditText recogerNombre = findViewById(R.id.inpt_nuevo_nombre_cliente);
        EditText recogerTelefono = findViewById(R.id.inpt_nuevo_telefono_cliente);

        int codigo = 1;
        String nombre = "" + recogerNombre.getText().toString();
        String telefono = "" + recogerTelefono.getText().toString();

        bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");

        bd.close();
    }
}
