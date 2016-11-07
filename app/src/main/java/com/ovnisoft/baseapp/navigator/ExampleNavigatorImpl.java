package com.ovnisoft.baseapp.navigator;

import android.os.Bundle;

import com.ovnisoft.baseapp.R;
import com.ovnisoft.baseapp.view.ExampleViewImpl;
import com.ovnisoft.baseapp.view.GetDataViewImpl;
import com.ovnisoft.baseapp.view.PostDataViewImpl;
import com.ovnisoft.navigator.ExampleNavigator;

public class ExampleNavigatorImpl extends BaseNavigatorImpl implements ExampleNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigator_single_view);
        showDefaultFragment();
    }

    @Override
    public void showDefaultFragment() {
        ExampleViewImpl exampleView = new ExampleViewImpl();
        replaceFragment(R.id.fl_container, exampleView);
    }

    @Override
    public void openGetScreen() {
        GetDataViewImpl getDataView = new GetDataViewImpl();
        replaceFragment(R.id.fl_container, getDataView);
    }

    @Override
    public void openPostScreen() {
        PostDataViewImpl postDataView = new PostDataViewImpl();
        replaceFragment(R.id.fl_container, postDataView);
    }
}
