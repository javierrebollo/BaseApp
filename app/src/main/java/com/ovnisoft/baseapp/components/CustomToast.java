package com.ovnisoft.baseapp.components;

import android.content.Context;
import android.widget.Toast;

public class CustomToast extends Toast {
    public CustomToast(Context context) {
        super(context);
    }

    public static void showMessage(Context context, int message) {
        makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
