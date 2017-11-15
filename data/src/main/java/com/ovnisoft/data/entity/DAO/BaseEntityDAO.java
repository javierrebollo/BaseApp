package com.ovnisoft.data.entity.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ovnisoft.data.helper.CustomSQLiteOpenHelper;

public abstract class BaseEntityDAO {
    protected static final String ID = "id";
    private CustomSQLiteOpenHelper mCustomSQLiteOpenHelper;

    public BaseEntityDAO(CustomSQLiteOpenHelper customSQLiteOpenHelper) {
        mCustomSQLiteOpenHelper = customSQLiteOpenHelper;
    }

    protected SQLiteDatabase getWritableDatabase() {
        return mCustomSQLiteOpenHelper.getWritableDatabase();
    }

    protected void executeQuery(String query) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();
    }
}
