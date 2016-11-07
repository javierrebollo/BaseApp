package com.ovnisoft;

import com.ovnisoft.data.controller.EntityExampleController;
import com.ovnisoft.tracker.TrackerController;
import com.ovnisoft.usesCase.GetDataUseCase;
import com.ovnisoft.usesCase.SaveDataUseCase;

public abstract class DependencyInjector {

    public abstract TrackerController provideTrackerController();

    //******************
    //*** CONTROLLER ***
    //******************
    protected abstract EntityExampleController provideEntityExampleController();


    //******************
    //**** USE CASES ***
    //******************

    protected GetDataUseCase provideGetDataUseCase() {
        return new GetDataUseCase(provideEntityExampleController());
    }

    protected SaveDataUseCase provideSaveDataUseCase() {
        return new SaveDataUseCase(provideEntityExampleController());
    }
}
