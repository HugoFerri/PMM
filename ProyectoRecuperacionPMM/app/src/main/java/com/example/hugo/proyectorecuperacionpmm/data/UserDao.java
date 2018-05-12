package com.example.hugo.proyectorecuperacionpmm.data;

import android.database.Cursor;

import com.example.hugo.proyectorecuperacionpmm.models.User;

public class UserDao implements DBContract.UserEntry {
    private SQLiteHelper sqLiteHelper;

    public UserDao(SQLiteHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public Cursor getUserByID(int id) {
        return sqLiteHelper.getReadableDatabase().query(
                TABLE_NAME,
                null,
                _ID + "=" + id,
                null,
                null,
                null,
                null);
    }

    public Cursor getUserByEmail(String email) {
        // Hay que entrecomillar el email porque la @ da problemas
        email = String.format("\"%s\"", email);
        return sqLiteHelper.getReadableDatabase().query(
                TABLE_NAME,
                null,
                KEY_EMAIL + "=" + email,
                null,
                null,
                null,
                null
        );
    }

    public Cursor getAllUsers() {
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

    public void insertUser(User user) {
        sqLiteHelper.getWritableDatabase().insert(
                TABLE_NAME,
                null,
                user.toContentValues()
        );
    }
}