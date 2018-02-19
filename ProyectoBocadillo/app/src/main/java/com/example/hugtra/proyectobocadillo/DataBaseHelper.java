package com.example.hugtra.proyectobocadillo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private Context mCtx = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "dbBocateria";
    private static final int DATABASE_VERSION = 3;

    // tabla y campos
    public static final String DATABASE_TABLE_BOCADILLOS = "Bocadillos";

    public static final String SL_ID_BOCADILLOS = "id";
    public static final String SL_INGREDIENTES = "ingredientes";
    public static final String SL_NAME = "name";
    public static final String SL_PRECIO = "precio";


    private static final String DATABASE_CREATE_BOCADILLOS =
            "create table " + DATABASE_TABLE_BOCADILLOS + " (" + SL_ID_BOCADILLOS +
                    " integer primary key, " + SL_NAME + " text not null, " + SL_PRECIO + " float,  "
                    + SL_INGREDIENTES + " text not null)";
    public static final String DATABASE_CREATE_PEDIDO = "CREATE TABLE pedidos (id INTEGER primary key autoincrement, id_food INTEGER, bocadillo TEXT," +
            "cantidad INTEGER not null,precio INTEGER not null,envio TEXT,extras TEXT)";

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE_BOCADILLOS);
        sqLiteDatabase.execSQL(DATABASE_CREATE_PEDIDO);


        sqLiteDatabase.execSQL("INSERT INTO bocadillos (id , ingredientes, name, precio) VALUES ('1', 'jamon, tomate', 'Bocadillo jamon', '2') ");
        sqLiteDatabase.execSQL("INSERT INTO bocadillos (id , ingredientes, name, precio) VALUES ('2', 'huevo, queso, patata, lechuga', 'Chivito','3') ");
        sqLiteDatabase.execSQL("INSERT INTO bocadillos (id , ingredientes, name, precio) VALUES ('3', 'tortilla de patata', 'Patatica','2') ");
        sqLiteDatabase.execSQL("INSERT INTO bocadillos (id , ingredientes, name, precio) VALUES ('4', 'bacon, queso, ternera', 'Sobadito','3') ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
