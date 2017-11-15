package com.ovnisoft.data.requests;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.google.gson.JsonSyntaxException;
import com.ovnisoft.data.BuildConfig;
import com.ovnisoft.data.entity.BaseEntity;
import com.ovnisoft.data.request.CustomResponse;
import com.ovnisoft.data.request.CustomResponseList;
import com.ovnisoft.data.request.ResponseCodes;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ServerRequest<T> {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient mClient;
    private final DataNetMapper<T> mDataNetMapper;
    private final Context mContext;

    public ServerRequest(Context context, DataNetMapper<T> dataNetMapper, ClientBuilder clientBuilder) {
        mContext = context;
        mClient = clientBuilder.getClient();
        mDataNetMapper = dataNetMapper;
    }

    public Request.Builder getBuilder(String url) {
        url = checkUrlFormat(url);

        if (!url.startsWith("http")) {
            url = BuildConfig.BASE_URL + url;
        }

        return new Request.Builder().url(url);
    }

    private String checkUrlFormat(String url) {
        if (!url.substring(url.length() - 1).equals("/")) {
            url = url + "/";
        }
        return url;
    }

    public CustomResponse<T> getRequest(String url) {
        return getResponse(getBuilder(url).build());
    }

    public CustomResponse<T> postRequest(String url, T bodyObject, Header... values) {
        Request.Builder builder = getBuilder(url);

        for (Header header : values) {
            builder.addHeader(header.getKey(), header.getValue());
        }

        if (bodyObject != null) {
            RequestBody body = RequestBody.create(JSON, mDataNetMapper.parseToString(bodyObject));
            builder.post(body);
        }

        Request request = builder.build();

        return getResponse(request);
    }

    public CustomResponseList<T> getRequestList(String url) {
        return getResponseList(getBuilder(url).build());
    }

    public CustomResponse<T> postRequest(String url, T bodyObject) {
        RequestBody body;
        if (bodyObject == null) {
            body = RequestBody.create(null, new byte[0]);
        } else {
            body = RequestBody.create(JSON, mDataNetMapper.parseToString(bodyObject));
        }
        Request request = getBuilder(url).post(body).build();

        return getResponse(request);
    }

    public CustomResponse<T> postRequest(String url, BaseEntity bodyObject, DataNetMapper bodyDataNetMapper) {
        RequestBody body = RequestBody.create(JSON, bodyDataNetMapper.parseToString(bodyObject));
        Request request = getBuilder(url).post(body).build();

        return getResponse(request);
    }

    public CustomResponse<T> postRawRequest(String url, String bodyObject) {
        RequestBody body = RequestBody.create(JSON, bodyObject);
        Request request = getBuilder(url).post(body).build();

        return getResponse(request);
    }

    public CustomResponseList<T> postRequestList(String url, List<T> bodyObject) {
        RequestBody body = RequestBody.create(JSON, mDataNetMapper.parseToStringList(bodyObject));
        Request request = getBuilder(url).post(body).build();

        return getResponseList(request);
    }

    public CustomResponseList<T> postRequestList(String url, List bodyObject, DataNetMapper bodyDataNetMapper) {
        RequestBody body = RequestBody.create(JSON, bodyDataNetMapper.parseToStringList(bodyObject));
        Request request = getBuilder(url).post(body).build();

        return getResponseList(request);
    }

    public CustomResponse<T> postMultipartRequest(String url, byte[] data) {

        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("photo", "photo.jpg",
                        RequestBody.create(MediaType.parse("image/png"), data))
                .build();

        Request request = getBuilder(url).post(body).build();

        return getResponse(request);
    }

    public CustomResponse<T> patchRequest(String url, T bodyObject) {
        RequestBody body = RequestBody.create(JSON, mDataNetMapper.parseToString(bodyObject));
        Request request = getBuilder(url).patch(body).build();

        return getResponse(request);
    }

    public CustomResponse<T> patchRequest(String url, Object bodyObject, DataNetMapper bodyDataNetMapper) {
        RequestBody body = RequestBody.create(JSON,
                (bodyDataNetMapper != null) ? bodyDataNetMapper.parseToString(bodyObject) : (String) bodyObject
        );
        Request request = getBuilder(url).patch(body).build();

        return getResponse(request);
    }

    public CustomResponse<T> deleteRequest(String url) {
        Request request = getBuilder(url).delete().build();

        return getResponse(request);
    }

    private synchronized CustomResponse<T> getResponse(Request request) {
        CustomResponse<T> customResponse;
        Response response;

        if (isOnline()) {
            try {
                response = mClient.newCall(request).execute();
                String stringResponse = response.body().string();
                Log.d(getClass().getCanonicalName(), "Response: " + stringResponse);
                customResponse = new CustomResponseImpl<>(
                        mDataNetMapper.parseToEntity(stringResponse),
                        response.code()
                );

            } catch (JsonSyntaxException | IOException | IllegalStateException e) {
                e.printStackTrace();
                customResponse = new CustomResponseImpl<>(null, ResponseCodes.BAD_REQUEST);
            }
        } else {
            customResponse = new CustomResponseImpl<>(null, ResponseCodes.WITHOUT_CONNECTIVITY);
        }

        return customResponse;
    }

    private synchronized CustomResponseList<T> getResponseList(Request request) {
        CustomResponseList<T> customResponse;
        Response response;

        if (isOnline()) {
            try {
                response = mClient.newCall(request).execute();
                String stringResponse = response.body().string();
                Log.d(getClass().getCanonicalName(), "Response: " + stringResponse);
                customResponse = new CustomResponseListImpl<>(
                        mDataNetMapper.parseToEntityList(stringResponse),
                        response.code()
                );

            } catch (JsonSyntaxException | IOException | IllegalStateException e) {
                e.printStackTrace();
                customResponse = new CustomResponseListImpl<>(null, ResponseCodes.BAD_REQUEST);
            }
        } else {
            customResponse = new CustomResponseListImpl<>(null, ResponseCodes.WITHOUT_CONNECTIVITY);
        }

        return customResponse;
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        //should check null because in airplane mode it will be null
        return (netInfo != null && netInfo.isConnected());
    }
}
