package com.ovnisoft.data.requests;


public class Header {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_LANGUAGE = "Accept-Language";
    public static final String HEADER_ENCODING = "Accept-Encoding";

    private String mKey;
    private String mValue;

    public Header(String key, String value) {
        mKey = key;
        mValue = value;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }
}
