package com.ovnisoft.baseapp;

import android.app.Application;
import android.content.Context;

import com.ovnisoft.DependencyInjector;
import com.ovnisoft.baseapp.presenter.ExamplePresenter;
import com.ovnisoft.baseapp.presenter.GetDataPresenter;
import com.ovnisoft.baseapp.tracker.TrackerControllerImpl;
import com.ovnisoft.baseapp.view.ExampleView;
import com.ovnisoft.baseapp.view.GetDataView;
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
        return new EntityExampleControllerImpl(new ServerRequest<EntityExample>(
                new DataNetMapper<EntityExample>(EntityExample.class)
        ));
    }

    //******************
    //*** PRESENTERS ***
    //******************
    public ExamplePresenter provideExamplePresenter(ExampleView view, ExampleNavigator navigator) {
        return new ExamplePresenter(view, navigator);
    }

    public GetDataPresenter provideGetDataPresenter(GetDataView view, ExampleNavigator navigator) {
        return new GetDataPresenter(view, navigator, provideGetDataInteractor());
    }

    @Override
    public TrackerController provideTrackerController() {
        return new TrackerControllerImpl();
    }
}
