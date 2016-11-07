package com.ovnisoft.baseapp.view;

import android.view.View;
import android.widget.Button;

import com.ovnisoft.baseapp.AndroidDependencyInjector;
import com.ovnisoft.baseapp.R;
import com.ovnisoft.baseapp.presenter.ExamplePresenter;
import com.ovnisoft.navigator.ExampleNavigator;
import com.ovnisoft.view.ExampleView;

public class ExampleViewImpl extends BaseViewImpl<ExamplePresenter> implements ExampleView {

    private Button mBtnGet;
    private Button mBtnPost;

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
        mBtnPost = (Button) view.findViewById(R.id.btnPost);
    }

    @Override
    protected void setListeners() {
        mBtnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.openGetScreen();
            }
        });
        mBtnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.openPostScreen();
            }
        });
    }
}
