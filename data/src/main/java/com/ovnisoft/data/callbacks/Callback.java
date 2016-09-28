package com.ovnisoft.data.callbacks;

import com.ovnisoft.data.errors.RequestError;

public interface Callback<T> {

    void onResponse(T response);

    void onFailure(RequestError error);

}
