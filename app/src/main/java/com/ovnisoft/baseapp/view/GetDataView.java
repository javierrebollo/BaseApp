package com.ovnisoft.baseapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ovnisoft.baseapp.AndroidDependencyInjector;
import com.ovnisoft.baseapp.R;
import com.ovnisoft.baseapp.presenter.GetDataPresenter;
import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.navigator.ExampleNavigator;

public class GetDataView extends BaseViewImpl<GetDataPresenter> {

    private Button mBtnGetData;
    private EditText mExampleId;
    private TextView mTvExampleData;

    @Override
    protected GetDataPresenter getPresenter() {
        return AndroidDependencyInjector.getInstance().provideGetDataPresenter(this, (ExampleNavigator) getActivity());
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.view_get_data;
    }

    @Override
    protected void initComponent(View view) {
        mBtnGetData = (Button) view.findViewById(R.id.btnGetData);
        mExampleId = (EditText) view.findViewById(R.id.etExampleId);
        mTvExampleData = (TextView) view.findViewById(R.id.tvExampleData);
    }

    @Override
    protected void setListeners() {
        mBtnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getData(mExampleId.getText().toString());
            }
        });
    }

    public void setData(EntityExample entityExample) {
        mTvExampleData.setText(entityExample.toString());
    }
}
