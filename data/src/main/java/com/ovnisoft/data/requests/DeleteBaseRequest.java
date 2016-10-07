package com.ovnisoft.data.requests;

import com.ovnisoft.data.entity.BaseEntity;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

interface DeleteBaseRequest<T extends BaseEntity> extends BaseRequest {

    @DELETE("{url}")
    Call<T> deleteRequest(@Path("url") String url);
}
