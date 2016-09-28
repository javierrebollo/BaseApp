package com.ovnisoft.data.requests;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OneRequestTest<T> extends BaseRequest {

    @GET("{url}")
    Call<T> getUser(@Path("url") String url);
}
