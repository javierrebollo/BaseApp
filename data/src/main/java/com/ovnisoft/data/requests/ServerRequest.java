package com.ovnisoft.data.requests;

import com.ovnisoft.data.callbacks.Callback;
import com.ovnisoft.data.entity.BaseEntity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ServerRequest<T extends BaseEntity> {
    public void request(type requestType, String url, Callback<T> callback) {
        switch (requestType) {
            case GET:
                getRequest(url, callback);
                break;
            case DELETE:
                deleteRequest(url, callback);
                break;
        }
    }

    public void request(type requestType, String url, T body, Callback<T> callback) {
        switch (requestType) {
            case POST:
                postRequest(url, body, callback);
                break;
            case PUT:
                putRequest(url, body, callback);
                break;
        }
    }

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
    private void deleteRequest(String url, final Callback<T> callback) {
        DeleteBaseRequest<T> deleteBaseRequest = DeleteBaseRequest.retrofit.create(DeleteBaseRequest.class);
        Call<T> call = deleteBaseRequest.deleteRequest(url);

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

    @SuppressWarnings("unchecked")
    private void postRequest(String url, T body, final Callback<T> callback) {
        PostBaseRequest<T> postBaseRequest = PostBaseRequest.retrofit.create(PostBaseRequest.class);
        Call<T> call = postBaseRequest.postRequest(url, body);

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

    @SuppressWarnings("unchecked")
    private void putRequest(String url, T body, final Callback<T> callback) {
        PutBaseRequest<T> putBaseRequest = PutBaseRequest.retrofit.create(PutBaseRequest.class);
        Call<T> call = putBaseRequest.putRequest(url, body);

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

    private enum type {GET, POST, PUT, DELETE}
}
