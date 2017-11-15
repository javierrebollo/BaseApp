package com.ovnisoft.data.requests;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class DataNetMapper<T> {

    private Class<T> mTClass;
    private Gson mGson;

    public DataNetMapper(Class<T> classType) {
        mTClass = classType;
        mGson = new Gson();
    }

    T parseToEntity(String body) {
        return mGson.fromJson(body, mTClass);
    }

    List<T> parseToEntityList(String body) {
        List<T> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(body);

            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(mGson.fromJson(jsonArray.get(i).toString(), mTClass));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    String parseToString(T body) {
        String bodyParser = mGson.toJson(body);
        Log.d(getClass().getSimpleName(), bodyParser);
        return bodyParser;
    }

    String parseToStringList(List<T> body) {
        return mGson.toJson(body);
    }
}
