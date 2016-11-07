package com.ovnisoft.baseapp.presenter;

import com.ovnisoft.navigator.BaseNavigator;
import com.ovnisoft.view.BaseView;

public abstract class BasePresenter<V extends BaseView, N extends BaseNavigator> {

    V mView;
    N mNavigator;

    BasePresenter(V view, N navigator) {
        this.mView = view;
        this.mNavigator = navigator;
    }

    public N getNavigator() {
        return mNavigator;
    }
}