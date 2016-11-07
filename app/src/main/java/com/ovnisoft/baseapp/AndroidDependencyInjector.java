package com.ovnisoft.baseapp;

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
import com.ovnisoft.data.requests.DataNetMapper;
import com.ovnisoft.data.requests.ServerRequest;
import com.ovnisoft.navigator.ExampleNavigator;
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

    //******************
    //*** CONTROLLER ***
    //******************

    @Override
    protected EntityExampleController provideEntityExampleController() {
        return new EntityExampleControllerImpl(new ServerRequest<>(
                new DataNetMapper<>(EntityExample.class)
        ));
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
