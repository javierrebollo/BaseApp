package com.ovnisoft.baseapp.view;

import android.view.View;
import android.widget.Button;

import com.ovnisoft.baseapp.AndroidDependencyInjector;
import com.ovnisoft.baseapp.R;
import com.ovnisoft.baseapp.presenter.ExamplePresenter;
import com.ovnisoft.navigator.ExampleNavigator;

public class ExampleView extends BaseViewImpl<ExamplePresenter> {

    private Button mBtnGet;

    @Override
    protected ExamplePresenter getPresenter() {
        return AndroidDependencyInjector.getInstance().provideExamplePresenter(this, (ExampleNavigator) getActivity());
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.view_example;
    }

    @Override
    protected void initComponent(View view) {
        mBtnGet = (Button) view.findViewById(R.id.btnGet);
    }

    @Override
    protected void setListeners() {
        mBtnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.openGetScreen();
            }
        });
    }
}
