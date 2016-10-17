package com.ovnisoft.data.requests;

import com.ovnisoft.data.request.CustomResponse;

public class CustomResponseImpl<T> implements CustomResponse<T> {

    private int mCode;
    private T mResponse;

    CustomResponseImpl(T response, int code) {
        mResponse = response;
        mCode = code;
    }

    @Override
    public int getCode() {
        return mCode;
    }

    @Override
    public T getResponse() {
        return mResponse;
    }
}
