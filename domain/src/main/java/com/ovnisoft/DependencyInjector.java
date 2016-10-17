package com.ovnisoft;

import com.ovnisoft.data.controller.EntityExampleController;
import com.ovnisoft.interactor.GetDataInteractor;
import com.ovnisoft.tracker.TrackerController;

public abstract class DependencyInjector {

    public abstract TrackerController provideTrackerController();

    //******************
    //*** CONTROLLER ***
    //******************
    protected abstract EntityExampleController provideEntityExampleController();


    //******************
    //*** INTERACTOR ***
    //******************

    public GetDataInteractor provideGetDataInteractor() {
        return new GetDataInteractor(provideEntityExampleController());
    }
}
