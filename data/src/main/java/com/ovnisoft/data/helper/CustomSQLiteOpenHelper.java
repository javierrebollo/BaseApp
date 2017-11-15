package com.ovnisoft.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ovnisoft.data.entity.DAO.ExampleDAO;

public class CustomSQLiteOpenHelper extends SQLiteOpenHelper {

    protected final static String DATABASE_NAME = "database.db";
    protected final static int DATABASE_VERSION = 3;
    private static CustomSQLiteOpenHelper sInstance;

    public CustomSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized CustomSQLiteOpenHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new CustomSQLiteOpenHelper(context);
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ExampleDAO.getCreateTableSentence());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    @Override
    public String getDatabaseName() {
        return DATABASE_NAME;
    }
}
