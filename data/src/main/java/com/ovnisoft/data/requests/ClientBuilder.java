package com.ovnisoft.data.requests;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class ClientBuilder {
    private static final int TIMEOUT_TIME = 30;

    public OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .writeTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
                .build();
    }
}
