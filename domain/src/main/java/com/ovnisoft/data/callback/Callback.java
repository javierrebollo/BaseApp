package com.ovnisoft.data.callback;

public interface Callback<T> {

    void onSuccess(T object);

    void onError();
}
