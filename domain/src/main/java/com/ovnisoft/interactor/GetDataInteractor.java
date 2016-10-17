package com.ovnisoft.interactor;

import com.ovnisoft.data.callback.Callback;
import com.ovnisoft.data.controller.EntityExampleController;
import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.data.request.CustomResponse;
import com.ovnisoft.data.request.ResponseCodes;

public class GetDataInteractor {

    private EntityExampleController mEntityExampleController;

    public GetDataInteractor(EntityExampleController entityExampleController) {
        mEntityExampleController = entityExampleController;
    }

    public void getData(final int entityExampleId, final Callback<EntityExample> callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                CustomResponse<EntityExample> customResponse =
                        mEntityExampleController.getEntityExample(new EntityExample(entityExampleId, null, null));

                if (customResponse.getCode() == ResponseCodes.OK) {
                    callback.onSuccess(customResponse.getResponse());
                } else {
                    callback.onError();
                }
            }
        });
    }
}
