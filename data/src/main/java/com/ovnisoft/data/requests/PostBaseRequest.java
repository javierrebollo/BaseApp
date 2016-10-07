package com.ovnisoft.data.requests;

import com.ovnisoft.data.entity.BaseEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface PostBaseRequest<T extends BaseEntity> extends BaseRequest {

    @POST("{url}")
    Call<T> postRequest(@Path("url") String url, @Body T body);
}
