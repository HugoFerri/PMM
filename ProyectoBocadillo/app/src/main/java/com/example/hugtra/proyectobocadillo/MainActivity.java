package com.example.hugtra.proyectobocadillo;

import android.app.Activity;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    String [] columnas = {"id" , "ingredientes", "name", "precio"};
    Bocadillo [] arrBocadillos;

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

        BocadilloHelper  bocadilloHelper = new BocadilloHelper(this, "dbBocateria", null, 1);
        SQLiteDatabase sqLiteDatabase = bocadilloHelper.getWritableDatabase();


        if(sqLiteDatabase != null){
            sqLiteDatabase.execSQL("INSERT INTO bocadillos (nombre, ingredientes, precio, id) VALUES ('Bocadillo jamon','Jamon, tomate','2', '1') ");
            sqLiteDatabase.execSQL("INSERT INTO bocadillos (nombre, ingredientes, precio, id) VALUES ('Chivito','huevo, queso, patata, lechuga','3', '2') ");
            sqLiteDatabase.execSQL("INSERT INTO bocadillos (nombre, ingredientes, precio, id) VALUES ('Patata','Tortilla de patata','2', '3') ");
            sqLiteDatabase.execSQL("INSERT INTO bocadillos (nombre, ingredientes, precio, id) VALUES ('Sobadito','bacon, queso, ternera','3', '4') ");
        }
        final EditText tvbocadillo = (EditText) findViewById(R.id.editText);
        final Spinner miSpinner = (Spinner) findViewById(R.id.spinner);

        class AdaptadorSpinnerBocadillo extends ArrayAdapter {

            Activity context;

            AdaptadorSpinnerBocadillo(Activity context) {
                super(context, R.layout.spinner_helper, bocadillo);
                this.context = context;
            }

            public View getDropDownView(int posicion, View convertView, ViewGroup parent) {
                return getView(posicion, convertView, parent);
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                View item = convertView;
                ViewHolder holder;

                if (item == null) {
                    LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.spinner_helper, null);

                    holder = new ViewHolder();
                    holder.nombre = (TextView) item.findViewById(R.id.nombre);
                    holder.ingre = (TextView) item.findViewById(R.id.ingredientes);
                    holder.precio = (TextView) item.findViewById(R.id.Precio);
                    holder.img = (ImageView) item.findViewById(R.id.image);

                    item.setTag(holder);

                } else {
                    holder = (ViewHolder) item.getTag();
                }

                holder.nombre.setText(bocadillo[position].getNombre());
                holder.ingre.setText(bocadillo[position].getIngredientes());
                String a = Integer.toString(bocadillo[position].getPrecio());
                holder.precio.setText(a);
                holder.img.setImageResource(bocadillo[position].getFoto());

                return (item);
            }
        }
        AdaptadorSpinnerBocadillo adaptadorSpin = new AdaptadorSpinnerBocadillo(this);
        miSpinner.setAdapter(adaptadorSpin);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

            }

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
                int precio = bocadillo[pos].getPrecio();
                int cont =0;

                int paso1 = añadido(cont);
                String comple = Integer.toString(paso1);

                int paso2 = cantidad(canti, precio);
                double total = envio(paso2 + paso1);

                String resultado = Double.toString(total);
                String tipoeenvio = envios();



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

