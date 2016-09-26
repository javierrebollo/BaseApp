package com.ovnisoft.baseapp;

import android.app.Application;
import android.content.Context;

import com.ovnisoft.DependencyInjector;
import com.ovnisoft.baseapp.tracker.TrackerControllerImpl;
import com.ovnisoft.tracker.TrackerController;

public class AndroidDependencyInjector extends DependencyInjector {

    private static AndroidDependencyInjector mInstance;
    private static Context mContext;
    private static Application mApplication;

    public static AndroidDependencyInjector getInstance() {
        if (mInstance == null) {
            mInstance = new AndroidDependencyInjector();
        }
        return mInstance;
    }

    public static void setApplication(Application application) {
        mApplication = application;
        mContext = application.getBaseContext();
    }

    @Override
    public TrackerController provideTrackerController() {
        return new TrackerControllerImpl();
    }
}
