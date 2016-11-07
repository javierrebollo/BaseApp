package com.ovnisoft.baseapp.presenter;

import com.ovnisoft.baseapp.view.ExampleViewImpl;
import com.ovnisoft.navigator.ExampleNavigator;

public class ExamplePresenter extends BasePresenter<ExampleViewImpl, ExampleNavigator> {

    public ExamplePresenter(ExampleViewImpl view, ExampleNavigator navigator) {
        super(view, navigator);
    }

    public void openGetScreen() {
        mNavigator.openGetScreen();
    }

    public void openPostScreen() {
        mNavigator.openPostScreen();
    }
}
