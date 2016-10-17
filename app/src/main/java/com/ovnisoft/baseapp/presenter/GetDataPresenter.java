package com.ovnisoft.baseapp.presenter;

import com.ovnisoft.baseapp.view.GetDataView;
import com.ovnisoft.data.callback.Callback;
import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.interactor.GetDataInteractor;
import com.ovnisoft.navigator.ExampleNavigator;

public class GetDataPresenter extends BasePresenter<GetDataView, ExampleNavigator> {

    private GetDataInteractor mGetDataInteractor;

    public GetDataPresenter(GetDataView view, ExampleNavigator navigator, GetDataInteractor getDataInteractor) {
        super(view, navigator);

        mGetDataInteractor = getDataInteractor;
    }

    public void getData(String entityExampleId) {
        int entityId = 0;

        try {
            entityId = Integer.parseInt(entityExampleId);
        } catch (NumberFormatException e) {
            //Set here control exception like a dialog or something like that
        }

        mGetDataInteractor.getData(entityId, new Callback<EntityExample>() {
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

    public void setData(EntityExample entityExample) {

    }
}
