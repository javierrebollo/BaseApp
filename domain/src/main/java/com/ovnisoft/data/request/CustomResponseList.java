package com.ovnisoft.data.request;


import java.util.List;

public interface CustomResponseList<T> {

    int getCode();

    List<T> getResponse();
}
