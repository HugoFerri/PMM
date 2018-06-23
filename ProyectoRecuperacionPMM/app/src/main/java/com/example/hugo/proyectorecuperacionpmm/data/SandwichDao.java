package com.example.hugo.proyectorecuperacionpmm.data;

import android.database.Cursor;

import com.example.hugo.proyectorecuperacionpmm.R;
import com.example.hugo.proyectorecuperacionpmm.model.Sandwich;

public class SandwichDAO implements DBContract.SandwichEntry {
    private SQLiteHelper sqLiteHelper;

    // Array con datos de prueba para poder probar la base de datos
    private static final Sandwich[] MOCK_DATA = {
            new Sandwich(
                    "Sandwich Jamon York",
                    "Lechuga, tomate, Jamon York, queso",
                    5.0f,
                    R.drawable.sandwich1
            ),
            new Sandwich(
                    "Sandwich Vegano",
                    "Lechuga, rucula, cosas veganas",
                    6.0f,
                    R.drawable.sandwich2
            ),
            new Sandwich(
                    "Sandwich triple",
                    "Pechuga, tomate, queso, lechuga",
                    7.0f,
                    R.drawable.sandwich3
            ),
    };

    public SandwichDAO(SQLiteHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public Cursor getSandwichByID(int id) {
        return sqLiteHelper.getReadableDatabase().query(
                TABLE_NAME,
                null,
                _ID + "=" + id,
                null,
                null,
                null,
                null);
    }

    public Cursor getSandwichByName(String name) {
        return sqLiteHelper.getReadableDatabase().query(
                TABLE_NAME,
                null,
                KEY_NAME + "=" + name,
                null,
                null,
                null,
                null
        );
    }

    public Cursor getAllSandwiches() {
        return sqLiteHelper.getReadableDatabase().query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public long insertSandwich(Sandwich sandwich) {
        return sqLiteHelper.getWritableDatabase().insert(
                TABLE_NAME,
                null,
                sandwich.toContentValues()
        );
    }

    public void insertMockData() {
        for (Sandwich sandwich : MOCK_DATA) {
            insertSandwich(sandwich);
        }
    }
}