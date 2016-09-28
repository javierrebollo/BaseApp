package com.ovnisoft.data.requests;

import com.ovnisoft.data.callbacks.Callback;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ServerRequest<T> {
    public enum type {GET, POST, PUT}

    public void request(type requestType, String url, Callback<T> callback) {
        switch (requestType) {
            case GET:
                getRequest(url, callback);
                break;
        }
    }

    private void getRequest(String url, final Callback<T> callback) {
        GetBaseRequest<T> getBaseRequest = GetBaseRequest.retrofit.create(GetBaseRequest.class);
        Call<T> call = getBaseRequest.getRequest(url);

        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                try {
                    T object = call.execute().body();
                    callback.onResponse(object);

                } catch (IOException e) {
                    callback.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callback.onFailure(null);
            }
        });
    }
}
