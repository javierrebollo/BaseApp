package com.ovnisoft.data.requests;

import com.ovnisoft.data.entity.BaseEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

interface PutBaseRequest<T extends BaseEntity> extends BaseRequest {

    @PUT("{url}")
    Call<T> putRequest(@Path("url") String url, @Body T body);
}
