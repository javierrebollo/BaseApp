package com.ovnisoft;

import com.ovnisoft.data.controller.EntityExampleController;
import com.ovnisoft.tracker.TrackerController;
import com.ovnisoft.usesCase.GetDataUseCase;

public abstract class DependencyInjector {

    public abstract TrackerController provideTrackerController();

    //******************
    //*** CONTROLLER ***
    //******************
    protected abstract EntityExampleController provideEntityExampleController();


    //******************
    //*** INTERACTOR ***
    //******************

    protected GetDataUseCase provideGetDataInteractor() {
        return new GetDataUseCase(provideEntityExampleController());
    }
}
