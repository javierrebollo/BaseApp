package com.ovnisoft.baseapp.presenter;

import com.ovnisoft.baseapp.view.ExampleView;
import com.ovnisoft.navigator.ExampleNavigator;

public class ExamplePresenter extends BasePresenter<ExampleView, ExampleNavigator> {

    public ExamplePresenter(ExampleView view, ExampleNavigator navigator) {
        super(view, navigator);
    }

    public void openGetScreen() {
        mNavigator.openGetScreen();
    }
}
