package com.example.hugo.proyectorecuperacionpmm.data;

import android.database.Cursor;

import com.example.hugo.proyectorecuperacionpmm.model.Order;

public class OrderDAO implements DBContract.OrderEntry {
    private SQLiteHelper sqLiteHelper;

    public OrderDAO(SQLiteHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public Cursor getOrderByID(int id) {
        return sqLiteHelper.getReadableDatabase().query(
                TABLE_NAME,
                null,
                _ID + "=" + id,
                null,
                null,
                null,
                null);
    }

    public Cursor getOrderByUserID(int userID) {
        return sqLiteHelper.getReadableDatabase().query(
                TABLE_NAME,
                null,
                KEY_USER_ID + "=" + userID,
                null,
                null,
                null,
                null
        );
    }

    public Cursor getAllOrders() {
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

    public long insertOrder(Order order) {
        return sqLiteHelper.getWritableDatabase().insert(
                TABLE_NAME,
                null,
                order.toContentValues()
        );
    }
}