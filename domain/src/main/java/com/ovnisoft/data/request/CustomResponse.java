package com.ovnisoft.data.request;


public interface CustomResponse<T> {

    int getCode();

    T getResponse();
}
