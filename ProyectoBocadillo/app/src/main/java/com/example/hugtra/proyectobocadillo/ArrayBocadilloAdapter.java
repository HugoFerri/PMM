package com.example.hugtra.proyectobocadillo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ArrayBocadilloAdapter extends ArrayAdapter<Bocadillo>{
    Context context;
    Bocadillo [] arrBocadillo;
    private TextView textViewPrecio, textViewNombre,textViewIngredientes,TVid;
    ImageView imageView ;


    public ArrayBocadilloAdapter(Context context, Bocadillo [] arrBocadillo) {
        super(context, R.layout.spinner_helper, arrBocadillo);
        this.context = context;
        this.arrBocadillo= arrBocadillo ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null){
            view = inflater.inflate(R.layout.spinner_helper,null);
        }

        textViewPrecio = view.findViewById(R.id.Precio);
        textViewNombre =  view.findViewById(R.id.nombre);
        textViewIngredientes =  view.findViewById(R.id.ingredientes);
        TVid = view.findViewById(R.id.id);

        imageView= view.findViewById(R.id.image);

        String cast = Float.toString(arrBocadillo[position].getPrecio());

        String cast2 = Integer.toString(arrBocadillo[position].getId());



        textViewPrecio.setText(cast);
        textViewNombre.setText(arrBocadillo[position].getNombre());
        textViewIngredientes.setText(arrBocadillo[position].getIngredientes());
        TVid.setText(cast2);

        switch (arrBocadillo[position].getId()){
            case 1:
                imageView.setImageResource(R.drawable.bocadillo1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.bocadillo2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.bocadillo3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.bocadillo4);
                break;
            default:
                break;
        }

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position,convertView,parent);
    }


}
