package com.ovnisoft.data.entity.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ovnisoft.data.entity.DAO.mapper.ExampleDAOMapper;
import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.data.helper.CustomSQLiteOpenHelper;

public class ExampleDAO extends BaseEntityDAO {

    //FIELDS
    public static final String EXAMPLE_USER_ID = "user_id";
    public static final String EXAMPLE_TITLE = "title";
    public static final String EXAMPLE_BODY = "body";

    //TABLE
    private static final String TABLE_NAME_EXAMPLE = "example";

    //DROP
    private final String TABLE_EXAMPLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME_EXAMPLE;

    //MAPPER
    private ExampleDAOMapper mExampleDAOMapper;

    public ExampleDAO(CustomSQLiteOpenHelper customSQLiteOpenHelper) {
        super(customSQLiteOpenHelper);
        mExampleDAOMapper = new ExampleDAOMapper();
    }

    public static String getCreateTableSentence() {
        return "CREATE TABLE " + TABLE_NAME_EXAMPLE
                + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EXAMPLE_USER_ID + " INTEGER, "
                + EXAMPLE_TITLE + " TEXT, "
                + EXAMPLE_BODY + " TEXT"
                + ");";
    }

    public long save(EntityExample entityToSave) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(EXAMPLE_USER_ID, entityToSave.getUserId());
        values.put(EXAMPLE_TITLE, entityToSave.getTitle());
        values.put(EXAMPLE_BODY, entityToSave.getBody());

        return db.insert(TABLE_NAME_EXAMPLE, null, values);
    }

    public EntityExample get(int id) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_EXAMPLE + " WHERE " + ID + " = " + id + "";
        Cursor cursor = db.rawQuery(query, null);

        return mExampleDAOMapper.mapEntityExample(cursor);
    }
}
