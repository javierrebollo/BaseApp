package com.ovnisoft.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitGetRequest<T extends RequestData> {
    @GET()
    Call<List<T>> getList();

    String getRoute();
}
