package com.ovnisoft.data.requests;

import com.google.gson.Gson;

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

    String parseToString(T body) {
        return mGson.toJson(body);
    }
}
