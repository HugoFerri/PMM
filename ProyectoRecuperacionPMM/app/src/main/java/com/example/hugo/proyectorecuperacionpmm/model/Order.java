package com.example.hugo.proyectorecuperacionpmm.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.hugo.proyectorecuperacionpmm.data.DBContract;

import java.text.DateFormat;
import java.util.Date;

public class Order implements DBContract, Parcelable  {
    private String address;
    private String date;
    private float price;
    private int userId;

    public Order(String address, float price, int userId) {
        // Obtenemos la fecha y hora del momento en el que se hace un nuevo pedido.
        Date date = new Date();

        this.address = address;
        this.date = DateFormat.getDateTimeInstance().format(date);
        this.price = price;
        this.userId = userId;
    }

    public Order(Cursor cursor) {
        this.address = cursor.getString(cursor.getColumnIndex(OrderEntry.KEY_ADDRESS));
        this.date = cursor.getString(cursor.getColumnIndex(OrderEntry.KEY_DATE));
        this.price = cursor.getFloat(cursor.getColumnIndex(OrderEntry.KEY_PRICE));
        this.userId = cursor.getInt(cursor.getColumnIndex(OrderEntry.KEY_USER_ID));
    }

    private Order(Parcel in) {
        address = in.readString();
        date = in.readString();
        price = in.readFloat();
        userId = in.readInt();
    }

    public static final Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(date);
        dest.writeFloat(price);
        dest.writeInt(userId);
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
        values.put(OrderEntry.KEY_PRICE, price);
        values.put(OrderEntry.KEY_USER_ID, userId);

        return values;
    }
}