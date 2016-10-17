package com.ovnisoft.data.requests;

import android.util.Log;

import com.ovnisoft.data.entity.BaseEntity;
import com.ovnisoft.data.request.CustomResponse;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ServerRequest<T extends BaseEntity> {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient mClient;
    private DataNetMapper<T> mDataNetMapper;


    public ServerRequest(DataNetMapper<T> dataNetMapper) {
        mClient = new OkHttpClient();
        mDataNetMapper = dataNetMapper;
    }

    public CustomResponse<T> getRequest(String url) {
        Request request = new Request.Builder()
                .url(RequestUrls.BASE_URL + url)
                .build();

        return getResponse(request);
    }

    public CustomResponse<T> postRequest(String url, T bodyObject) {
        RequestBody body = RequestBody.create(JSON, mDataNetMapper.parseToString(bodyObject));
        Request request = new Request.Builder()
                .url(RequestUrls.BASE_URL + url)
                .post(body)
                .build();

        return getResponse(request);
    }

    public CustomResponse<T> putRequest(String url, T bodyObject) {
        RequestBody body = RequestBody.create(JSON, mDataNetMapper.parseToString(bodyObject));
        Request request = new Request.Builder()
                .url(RequestUrls.BASE_URL + url)
                .put(body)
                .build();

        return getResponse(request);
    }

    public CustomResponse<T> deleteRequest(String url) {
        Request request = new Request.Builder()
                .url(RequestUrls.BASE_URL + url)
                .delete()
                .build();

        return getResponse(request);
    }

    private CustomResponse<T> getResponse(Request request) {
        CustomResponse<T> customResponse = null;
        Response response = null;
        try {
            response = mClient.newCall(request).execute();
            String stringResponse = response.body().toString();
            Log.d(getClass().getCanonicalName(), "Response: " + stringResponse);
            customResponse = new CustomResponseImpl<>(
                    mDataNetMapper.parseToEntity(stringResponse),
                    response.code()
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
        return customResponse;
    }
}
