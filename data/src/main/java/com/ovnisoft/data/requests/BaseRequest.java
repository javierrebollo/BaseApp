package com.ovnisoft.data.requests;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

interface BaseRequest {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(RequestUrls.BASE_URL)
            .client(new OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
