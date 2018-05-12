package com.example.hugo.proyectorecuperacionpmm.models;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.hugo.proyectorecuperacionpmm.data.DBContract;

public class Sandwich implements DBContract {
    private String name;
    private String ingredients;
    private float price;
    private int photo_id;

    public Sandwich(String name, String ingredients, float price, int photo_id) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.photo_id = photo_id;
    }

    public Sandwich(Cursor cursor) {
        this.name = cursor.getString(cursor.getColumnIndex(SandwichEntry.KEY_NAME));
        this.ingredients = cursor.getString(cursor.getColumnIndex(SandwichEntry.KEY_INGREDIENTS));
        this.price = cursor.getFloat(cursor.getColumnIndex(SandwichEntry.KEY_PRICE));
        this.photo_id = cursor.getInt(cursor.getColumnIndex(SandwichEntry.KEY_PHOTO_ID));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put(SandwichEntry.KEY_NAME, name);
        values.put(SandwichEntry.KEY_INGREDIENTS, ingredients);
        values.put(SandwichEntry.KEY_PRICE, price);
        values.put(SandwichEntry.KEY_PHOTO_ID, photo_id);

        return values;
    }
}
