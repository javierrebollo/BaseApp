package com.ovnisoft.data.errors;

public class RequestError {
    private int mErrorCode;
    private String mErrorMessage;

    public RequestError(int errorCode, String errorMessage) {
        mErrorCode = errorCode;
        mErrorMessage = errorMessage;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }
}
