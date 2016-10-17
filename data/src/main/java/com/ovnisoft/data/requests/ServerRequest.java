package com.ovnisoft.data.requests;

import com.ovnisoft.data.callbacks.CallbackDataRequest;
import com.ovnisoft.data.entity.BaseEntity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ServerRequest<T extends BaseEntity> {
    public void request(type requestType, String url, CallbackDataRequest<T> callbackDataRequest) {
        switch (requestType) {
            case GET:
                getRequest(url, callbackDataRequest);
                break;
            case DELETE:
                deleteRequest(url, callbackDataRequest);
                break;
        }
    }

    public void request(type requestType, String url, T body, CallbackDataRequest<T> callbackDataRequest) {
        switch (requestType) {
            case POST:
                postRequest(url, body, callbackDataRequest);
                break;
            case PUT:
                putRequest(url, body, callbackDataRequest);
                break;
        }
    }

    @SuppressWarnings("unchecked")
    private void getRequest(String url, final CallbackDataRequest<T> callbackDataRequest) {
        GetBaseRequest<T> getBaseRequest = GetBaseRequest.retrofit.create(GetBaseRequest.class);
        Call<T> call = getBaseRequest.getRequest(url);

        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                try {
                    T object = call.execute().body();
                    callbackDataRequest.onResponse(new com.ovnisoft.data.requests.Response<T>(object, response.code()));

                } catch (IOException e) {
                    callbackDataRequest.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callbackDataRequest.onFailure(null);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void deleteRequest(String url, final CallbackDataRequest<T> callbackDataRequest) {
        DeleteBaseRequest<T> deleteBaseRequest = DeleteBaseRequest.retrofit.create(DeleteBaseRequest.class);
        Call<T> call = deleteBaseRequest.deleteRequest(url);

        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                try {
                    T object = call.execute().body();
                    callbackDataRequest.onResponse(new com.ovnisoft.data.requests.Response<T>(object, response.code()));

                } catch (IOException e) {
                    callbackDataRequest.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callbackDataRequest.onFailure(null);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void postRequest(String url, T body, final CallbackDataRequest<T> callbackDataRequest) {
        final PostBaseRequest<T> postBaseRequest = PostBaseRequest.retrofit.create(PostBaseRequest.class);
        Call<T> call = postBaseRequest.postRequest(url, body);

        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                try {
                    T object = call.execute().body();
                    callbackDataRequest.onResponse(new com.ovnisoft.data.requests.Response<T>(object, response.code()));

                } catch (IOException e) {
                    callbackDataRequest.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callbackDataRequest.onFailure(null);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void putRequest(String url, T body, final CallbackDataRequest<T> callbackDataRequest) {
        PutBaseRequest<T> putBaseRequest = PutBaseRequest.retrofit.create(PutBaseRequest.class);
        Call<T> call = putBaseRequest.putRequest(url, body);

        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                try {
                    T object = call.execute().body();
                    callbackDataRequest.onResponse(new com.ovnisoft.data.requests.Response<T>(object, response.code()));

                } catch (IOException e) {
                    callbackDataRequest.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callbackDataRequest.onFailure(null);
            }
        });
    }

    public enum type {GET, POST, PUT, DELETE}
}
