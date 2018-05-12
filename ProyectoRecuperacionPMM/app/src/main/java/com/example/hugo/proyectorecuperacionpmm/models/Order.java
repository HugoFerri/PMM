package com.example.hugo.proyectorecuperacionpmm.models;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.hugo.proyectorecuperacionpmm.data.DBContract;

import java.text.DateFormat;
import java.util.Date;

public class Order implements DBContract {
    private String address;
    private String date;
    private int userId;

    public Order(String address, int userId) {
        // Obtenemos la fecha y hora del momento en el que se hace un nuevo pedido.
        Date date = new Date();

        this.address = address;
        this.date = DateFormat.getDateTimeInstance().format(date);
        this.userId = userId;
    }

    public Order(Cursor cursor) {
        this.address = cursor.getString(cursor.getColumnIndex(OrderEntry.KEY_ADDRESS));
        this.date = cursor.getString(cursor.getColumnIndex(OrderEntry.KEY_DATE));
        this.userId = cursor.getInt(cursor.getColumnIndex(OrderEntry.KEY_USER_ID));
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put(OrderEntry.KEY_ADDRESS, address);
        values.put(OrderEntry.KEY_DATE, date);
        values.put(OrderEntry.KEY_USER_ID, userId);

        return values;
    }
}