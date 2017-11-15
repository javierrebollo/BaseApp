package com.ovnisoft.data.entity.DAO.mapper;

import android.database.Cursor;

import com.ovnisoft.data.entity.EntityExample;

import java.util.ArrayList;
import java.util.List;

import static com.ovnisoft.data.entity.DAO.ExampleDAO.EXAMPLE_BODY;
import static com.ovnisoft.data.entity.DAO.ExampleDAO.EXAMPLE_TITLE;
import static com.ovnisoft.data.entity.DAO.ExampleDAO.EXAMPLE_USER_ID;

public class ExampleDAOMapper {

    public EntityExample mapEntityExample(Cursor cursor) {
        EntityExample entityExample = null;

        List<EntityExample> entityExampleList = mapEntityExampleList(cursor);

        if (entityExampleList.size() == 1) {
            entityExample = entityExampleList.get(0);
        }

        return entityExample;
    }

    public List<EntityExample> mapEntityExampleList(Cursor cursor) {
        List<EntityExample> entityExampleList = new ArrayList<>();

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                int userId = cursor.getInt(cursor.getColumnIndex(EXAMPLE_USER_ID));
                String title = cursor.getString(cursor.getColumnIndex(EXAMPLE_TITLE));
                String body = cursor.getString(cursor.getColumnIndex(EXAMPLE_BODY));

                entityExampleList.add(new EntityExample(userId, title, body));
            }
        }

        cursor.close();

        return entityExampleList;
    }

}
