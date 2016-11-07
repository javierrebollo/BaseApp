package com.ovnisoft.baseapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ovnisoft.baseapp.AndroidDependencyInjector;
import com.ovnisoft.baseapp.R;
import com.ovnisoft.baseapp.components.CustomToast;
import com.ovnisoft.baseapp.presenter.PostDataPresenter;
import com.ovnisoft.navigator.ExampleNavigator;
import com.ovnisoft.view.PostDataView;

public class PostDataViewImpl extends BaseViewImpl<PostDataPresenter> implements PostDataView {

    private Button mBtnPostData;
    private EditText mEtTitle;
    private EditText mEtBody;

    @Override
    protected PostDataPresenter getPresenter() {
        return AndroidDependencyInjector.getInstance().providePostDataPresenter(this, (ExampleNavigator) getActivity());
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.view_post_data;
    }

    @Override
    protected void initComponent(View view) {
        mBtnPostData = (Button) view.findViewById(R.id.btnPostData);
        mEtTitle = (EditText) view.findViewById(R.id.etTitle);
        mEtBody = (EditText) view.findViewById(R.id.etBody);
    }

    @Override
    protected void setListeners() {
        mBtnPostData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.saveData(mEtTitle.getText().toString(), mEtBody.getText().toString());
            }
        });
    }

    @Override
    public void showIfDataIsSaved(int message) {
        CustomToast.showMessage(getContext(), message);
    }
}
