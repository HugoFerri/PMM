package com.example.hugtra.paso_objetos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    static class ViewHolder{
        TextView nombre;
        TextView tipo;
        TextView precio;
        ImageView foto;

    }

    private Campeon[] campeon=new Campeon[]{
            new Campeon("Jax","Melé",1350,R.drawable.jax),
            new Campeon("GankPlank","Melé",3150,R.drawable.gp),
            new Campeon("Alistar","Melé",1350,R.drawable.alistar)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Bundle pasar_datos = new Bundle();
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final Button btt = (Button)findViewById(R.id.btt);


        class AdaptadorSpinner extends ArrayAdapter <Campeon>{

            Activity context;

            AdaptadorSpinner(Activity context){
                super(context,R.layout.spinner_helper,campeon);
                this.context=context;
            }
            public View getDropDownView(int posicion, View convertView, ViewGroup parent) {
                return getView(posicion, convertView, parent);
            }
            public View getView(int position, View convertView, ViewGroup parent ){
                View item =convertView;
                ViewHolder holder;


                if (item==null){

                    LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.spinner_helper, null);

                    holder = new ViewHolder();

                    holder.nombre=(TextView)item.findViewById(R.id.nombre);
                    holder.tipo=(TextView)item.findViewById(R.id.tipo);
                    holder.precio=(TextView)item.findViewById(R.id.precio);
                    holder.foto=(ImageView)item.findViewById(R.id.foto);

                    item.setTag(holder);

                }else{
                    holder = (ViewHolder)item.getTag();
                }
                holder.nombre.setText(campeon[position].getNombre());
                holder.tipo.setText(campeon[position].getTipo());
                String price = Integer.toString(campeon[position].getPrecio());
                holder.precio.setText(price);
                holder.foto.setImageResource(campeon[position].getFoto());


                return  (item);
            }
        }
        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(this);
        spinner.setAdapter(adaptadorSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pasar_datos.putSerializable("Campeon", campeon[spinner.getSelectedItemPosition()]);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });




       btt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               final Intent miIntent = new Intent(MainActivity.this,Pantalla2.class);
               miIntent.putExtras(pasar_datos);
               startActivity(miIntent);
           }
       });
    }
}
