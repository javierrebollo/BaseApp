package com.ovnisoft.data.request;

public class ResponseCodes {
    public static final int WITHOUT_CONNECTIVITY = -1;

    //2xx Success
    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int NO_CONTENT = 204;

    //3xx Redirection
    public static final int NO_MODIFIED = 304;

    //4xx Client error
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int CONFLICT = 409;

    //5xx Server error
    public static final int INTERNAL_SERVER_ERROR = 500;
}
