package com.ovnisoft.data.requests;

public class Response<T> {

    private int mCode;
    private T mResponse;

    Response(T response, int code) {
        mResponse = response;
        mCode = code;
    }

    public int getCode() {
        return mCode;
    }

    public T getResponse() {
        return mResponse;
    }
}
