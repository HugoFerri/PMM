package com.example.hugtra.proyectobocadillo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] columnas = {"id" , "ingredientes", "name", "precio"};
    Bocadillo [] arrBocadillos;
    SQLiteDatabase sqLiteDatabase;
    PedidoHelper pedidoHelper;
    
    static class ViewHolder {
        TextView nombre;
        TextView precio;
        TextView ingre;
        ImageView img;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tvbocadillo = (EditText) findViewById(R.id.editText);
        final Spinner miSpinner = (Spinner) findViewById(R.id.spinner);
        BocadilloHelper bocadilloHelper = new BocadilloHelper(this, "dbBocateria", null, 1);

        //Abrimos la base de datos para que sea editable
        sqLiteDatabase = bocadilloHelper.getWritableDatabase();

        if(sqLiteDatabase == null){
            sqLiteDatabase.execSQL("INSERT INTO bocadillos (id , ingredientes, name, precio) VALUES ('1', 'Jamon, tomate', 'Bocadillo jamon', '2') ");
            sqLiteDatabase.execSQL("INSERT INTO bocadillos (id , ingredientes, name, precio) VALUES ('2', 'huevo, queso, patata, lechuga', 'Chivito','3') ");
            sqLiteDatabase.execSQL("INSERT INTO bocadillos (id , ingredientes, name, precio) VALUES ('3', 'Tortilla de patata', 'Patatica','2') ");
            sqLiteDatabase.execSQL("INSERT INTO bocadillos (id , ingredientes, name, precio) VALUES ('4', 'bacon, queso, ternera', 'Sobadito','3') ");
        }
        //Creamos un cursor
        Cursor cursor = sqLiteDatabase.query("Bocadillos", columnas,null,null,null,null,null);

        //Inicializamos el array con el tamaño que tenga el cursor al hacer el conteo
        arrBocadillos = new Bocadillo[cursor.getCount()];

        //recoger los datos de la BD y los almaceno en un array
        if (cursor.moveToFirst()){
            int i = 0;
            do {
                int id = cursor.getInt(0);
                String ingredientes = cursor.getString(1);
                String name = cursor.getString(2);
                float precio = cursor.getFloat(3);

                arrBocadillos[i] = new Bocadillo(name,precio,ingredientes, id);

                i++;
            }while(cursor.moveToNext());
        }



        ArrayBocadilloAdapter arrayBocadilloAdapter = new ArrayBocadilloAdapter(this, arrBocadillos);
        miSpinner.setAdapter(arrayBocadilloAdapter);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                        String test = "ID: "+arrBocadillos[position].getId();

                Toast.makeText(getApplicationContext(),test,Toast.LENGTH_SHORT).show();            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final Button botonpasar = (Button) findViewById(R.id.button);
        final RadioButton r1 = (RadioButton) findViewById(R.id.rb1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.rb2);
        final CheckBox ch1 = (CheckBox) findViewById(R.id.cb1);
        final CheckBox ch2 = (CheckBox) findViewById(R.id.cb2);
        final CheckBox ch3 = (CheckBox) findViewById(R.id.cb3);

        botonpasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cantidad = tvbocadillo.getText().toString();

                int canti = Integer.parseInt(cantidad);
                int pos = miSpinner.getSelectedItemPosition();
                int precio = (int) arrBocadillos[pos].getPrecio();
                int cont =0;

                int paso1 = añadido(cont);
                String comple = Integer.toString(paso1);

                int paso2 = cantidad(canti, precio);
                double total = envio(paso2 + paso1);

                String resultado = Double.toString(total);
                String tipoeenvio = envios();

                pedidoHelper = new PedidoHelper(this, "dbBocateria", null, 1)

                sqLiteDatabase = pedidoHelper.getWritableDatabase();

                sqLiteDatabase.execSQL(PedidoHelper.DATABASE_CREATE_PEDIDO);
                sqLiteDatabase.execSQL("INSERT INTO pedidos (barra,bocadillo,cantidad,precio,envio) VALUES ( '" +tipoExtra+"',' "+ sandwich +  "','" +catida +
                        "',' " +resultado+"','"+ tipoeenvio+"') ");

                Intent miIntent = new Intent(MainActivity.this, Resultado.class);

                startActivity(miIntent);

            }

            public int añadido(int cont) {
                if (ch1.isChecked())
                    cont++;
                if (ch2.isChecked())
                    cont++;
                if (ch3.isChecked())
                    cont++;
                return cont;
            }

            public double envio(int precio) {
                double total = 0;
                if (r2.isChecked()){
                    total = precio + precio * 0.1;
                    return total;}
                else
                    return precio;

            }

            public int cantidad(int numero, int precio) {
                int total = numero * precio;
                return total;
            }

            public String envios() {
                String x = "";
                if (r1.isChecked()) {
                    x = "En el local";
                } else if (r2.isChecked()) {
                    x = "Envio domicilio";
                }
                return x;

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.AcercaDe:
                Intent one = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(one);
                return true;
            case R.id.Dibujo:
                Intent two = new Intent(MainActivity.this, Imagen.class);
                startActivity(two);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

