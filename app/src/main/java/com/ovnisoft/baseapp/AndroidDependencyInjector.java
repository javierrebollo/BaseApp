package com.ovnisoft.baseapp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.ovnisoft.DependencyInjector;
import com.ovnisoft.baseapp.presenter.ExamplePresenter;
import com.ovnisoft.baseapp.presenter.GetDataPresenter;
import com.ovnisoft.baseapp.presenter.PostDataPresenter;
import com.ovnisoft.baseapp.tracker.TrackerControllerImpl;
import com.ovnisoft.baseapp.view.ExampleViewImpl;
import com.ovnisoft.baseapp.view.GetDataViewImpl;
import com.ovnisoft.baseapp.view.PostDataViewImpl;
import com.ovnisoft.data.controller.EntityExampleController;
import com.ovnisoft.data.controller.EntityExampleControllerImpl;
import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.data.requests.ClientBuilder;
import com.ovnisoft.data.requests.DataNetMapper;
import com.ovnisoft.data.requests.ServerRequest;
import com.ovnisoft.navigator.ExampleNavigator;
import com.ovnisoft.tracker.TrackerController;

public class AndroidDependencyInjector extends DependencyInjector {

    @SuppressLint("StaticFieldLeak")
    private static AndroidDependencyInjector mInstance;
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    @SuppressLint("StaticFieldLeak")
    private static Application mApplication;
    private ClientBuilder mClientBuilder;

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

    //************************
    //**** SERVER REQUEST ****
    //************************
    private ClientBuilder provideClientBuilder() {
        if (mClientBuilder == null) {
            mClientBuilder = new ClientBuilder();
        }
        return mClientBuilder;
    }

    private ServerRequest provideServerRequest(Class responseClass) {
        return new ServerRequest<>(mContext, new DataNetMapper<>(responseClass), provideClientBuilder());
    }

    //******************
    //*** CONTROLLER ***
    //******************

    @Override
    protected EntityExampleController provideEntityExampleController() {
        return new EntityExampleControllerImpl(provideServerRequest(EntityExample.class));
    }

    //******************
    //*** PRESENTERS ***
    //******************
    public ExamplePresenter provideExamplePresenter(ExampleViewImpl view, ExampleNavigator navigator) {
        return new ExamplePresenter(view, navigator);
    }

    public GetDataPresenter provideGetDataPresenter(GetDataViewImpl view, ExampleNavigator navigator) {
        return new GetDataPresenter(view, navigator, provideGetDataUseCase());
    }

    public PostDataPresenter providePostDataPresenter(PostDataViewImpl view, ExampleNavigator navigator) {
        return new PostDataPresenter(view, navigator, provideSaveDataUseCase());
    }

    @Override
    public TrackerController provideTrackerController() {
        return new TrackerControllerImpl();
    }
}
