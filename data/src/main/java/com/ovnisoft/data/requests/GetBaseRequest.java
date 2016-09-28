package com.ovnisoft.data.requests;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface GetBaseRequest<T> extends BaseRequest {

    @GET("{url}")
    Call<T> getRequest(@Path("url") String url);
}
