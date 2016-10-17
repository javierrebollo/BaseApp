package com.ovnisoft.baseapp.navigator;

import android.os.Bundle;

import com.ovnisoft.baseapp.R;
import com.ovnisoft.baseapp.view.ExampleView;
import com.ovnisoft.baseapp.view.GetDataView;
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
        ExampleView exampleView = new ExampleView();
        replaceFragment(R.id.fl_container, exampleView);
    }

    @Override
    public void openGetScreen() {
        GetDataView getDataView = new GetDataView();
        replaceFragment(R.id.fl_container, getDataView);
    }
}
