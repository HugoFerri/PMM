package com.example.hugtra.proyectobocadillo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BocadilloHelper extends SQLiteOpenHelper{
    private Context mCtx = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "dbBocateria";
    private static final int DATABASE_VERSION = 3;
    // tabla y campos
    public static final String DATABASE_TABLE_BOCADILLOS = "Bocadillos";

    public static final String SL_ID_BOCADILLOS= "id";
    public static final String SL_INGREDIENTES= "ingredientes";
    public static final String SL_NAME= "name";
    public static final String SL_PRECIO= "precio";


    private static final String DATABASE_CREATE_BOCADILLOS =
            "create table "+ DATABASE_TABLE_BOCADILLOS +" ("+SL_ID_BOCADILLOS+
                    " integer primary key, "+SL_NAME+" text not null, "+SL_PRECIO+" float,  "
                    +SL_INGREDIENTES+" text not null)";

    public BocadilloHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE_BOCADILLOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}