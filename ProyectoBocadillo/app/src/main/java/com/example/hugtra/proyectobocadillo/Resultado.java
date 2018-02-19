package com.example.hugtra.proyectobocadillo;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Resultado extends ListActivity {
    private Bocadillo bocadillo;
    TextView nom;
    String[] columnaspedidos = new String[]{"bocadillo", "cantidad", "precio", "envio", "extras"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        fillData();
    }

    private void fillData() {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, "dbBocateria", null, 1);
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();

        Cursor itemCursor = sqLiteDatabase.query("pedidos", columnaspedidos, null, null, null, null, null);
        InfoBocadillos item = null;

        ArrayList<InfoBocadillos> resultList = new ArrayList<>();

        while (itemCursor.moveToNext()) {
            float precioget = itemCursor.getFloat(itemCursor.getColumnIndex("precio"));
            String extrasget = itemCursor.getString(itemCursor.getColumnIndex("extras"));
            String envioget = itemCursor.getString(itemCursor.getColumnIndex("envio"));
            String bocadilloget = itemCursor.getString(itemCursor.getColumnIndex("bocadillo"));
            int cantidadget = itemCursor.getInt(itemCursor.getColumnIndex("cantidad"));
            int ids = itemCursor.getInt(itemCursor.getColumnIndex("id_food"));

            item = new InfoBocadillos();

            item.id = ids;
            item.extas = extrasget;
            item.envio = envioget;
            item.precio = precioget;
            item.cantidad = cantidadget;
            item.bocadillo = bocadilloget;
            resultList.add(item);
        }
        itemCursor.close();
        sqLiteDatabase.close();

        TaskAdapter items = new TaskAdapter(this, R.layout.adaptador_lista, resultList, getLayoutInflater());
        setListAdapter(items);
    }

    private class InfoBocadillos {
        int id;
        String extas;
        String envio;
        int cantidad;
        String bocadillo;
        float precio;
    }

    private class TaskAdapter extends ArrayAdapter<InfoBocadillos> {
        private LayoutInflater mInflater;
        private List<InfoBocadillos> mObjects;

        private TaskAdapter(Context context, int resource, List<InfoBocadillos> objects, LayoutInflater mInflater) {
            super(context, resource, objects);
            this.mInflater = mInflater;
            this.mObjects = objects;
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InfoBocadillos listEntry = mObjects.get(position);

        View row = mInflater.inflate(R.layout.adaptador_lista, null);

        TextView extras = (TextView) row.findViewById(R.id.row_extras);
        TextView envios = (TextView) row.findViewById(R.id.row_envio);
        TextView sandwich = (TextView) row.findViewById(R.id.row_sandwich);
        TextView precio = (TextView) row.findViewById(R.id.row_precio);
        TextView cantidad = (TextView) row.findViewById(R.id.row_cantidad);
        TextView cliente = (TextView) row.findViewById(R.id.clienteName);

        extras.setText(listEntry.extas);
        envios.setText(listEntry.envio);
        sandwich.setText(listEntry.bocadillo);
        precio.setText(Float.toString(listEntry.precio));
        cantidad.setText(Integer.toString(listEntry.cantidad));

        // dependiendo de la importancia, se muestran distintos iconos
        ImageView icon = (ImageView) row.findViewById(R.id.row_importance);
        icon.setTag(listEntry.id);
        switch (listEntry.id) {
            case 1:
                icon.setImageResource(R.drawable.bocadillo1);
                break;
            case 2:
                icon.setImageResource(R.drawable.bocadillo2);
                break;
            case 3:
                icon.setImageResource(R.drawable.bocadillo3);
                break;
            case 4:
                icon.setImageResource(R.drawable.bocadillo4);
                break;
            default:

                break;
        }
        return row;
    }
}


}




