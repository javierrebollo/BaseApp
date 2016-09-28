package com.ovnisoft.baseapp.presenter;

import com.ovnisoft.navigator.BaseNavigator;
import com.ovnisoft.view.BaseView;

public abstract class BasePresenterImpl<V extends BaseView, N extends BaseNavigator> {

    protected V mView;
    protected N mNavigator;

    public BasePresenterImpl(V view, N navigator) {
        this.mView = view;
        this.mNavigator = navigator;
    }

    public N getNavigator() {
        return mNavigator;
    }
}