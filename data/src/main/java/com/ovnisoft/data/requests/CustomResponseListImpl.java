package com.ovnisoft.data.requests;

import com.ovnisoft.data.request.CustomResponseList;

import java.util.List;

public class CustomResponseListImpl<T> implements CustomResponseList<T> {

    private int mCode;
    private List<T> mResponse;

    CustomResponseListImpl(List<T> response, int code) {
        mResponse = response;
        mCode = code;
    }

    @Override
    public int getCode() {
        return mCode;
    }

    @Override
    public List<T> getResponse() {
        return mResponse;
    }
}
