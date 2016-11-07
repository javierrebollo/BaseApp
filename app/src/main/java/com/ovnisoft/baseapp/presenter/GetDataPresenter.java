package com.ovnisoft.baseapp.presenter;

import android.os.Handler;

import com.ovnisoft.baseapp.view.GetDataViewImpl;
import com.ovnisoft.data.callback.Callback;
import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.navigator.ExampleNavigator;
import com.ovnisoft.usesCase.GetDataUseCase;

public class GetDataPresenter extends BasePresenter<GetDataViewImpl, ExampleNavigator> {

    private GetDataUseCase mGetDataUseCase;

    public GetDataPresenter(GetDataViewImpl view, ExampleNavigator navigator, GetDataUseCase getDataUseCase) {
        super(view, navigator);

        mGetDataUseCase = getDataUseCase;
    }

    public void getData(String entityExampleId) {
        int entityId = 0;

        try {
            entityId = Integer.parseInt(entityExampleId);
        } catch (NumberFormatException e) {
            //Set here control exception like a dialog or something like that
        }

        mGetDataUseCase.getData(entityId, new Callback<EntityExample>() {
            @Override
            public void onSuccess(EntityExample entityExample) {
                setData(entityExample);
            }

            @Override
            public void onError() {
                //Show error
            }
        });
    }

    public void setData(final EntityExample entityExample) {
        Handler handler = new Handler(mView.getContext().getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                mView.setData(entityExample);
            }
        });
    }
}
