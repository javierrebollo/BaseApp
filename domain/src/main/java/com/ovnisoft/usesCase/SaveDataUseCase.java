package com.ovnisoft.usesCase;

import com.ovnisoft.data.callback.Callback;
import com.ovnisoft.data.controller.EntityExampleController;
import com.ovnisoft.data.entity.EntityExample;

public class SaveDataUseCase {

    private EntityExampleController mEntityExampleController;

    public SaveDataUseCase(EntityExampleController entityExampleController) {
        mEntityExampleController = entityExampleController;
    }

    public void saveData(final EntityExample entityExample, final Callback<EntityExample> callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (mEntityExampleController.saveEntityExample(entityExample)) {
                    callback.onSuccess(null);
                } else {
                    callback.onError();
                }
            }
        }).start();
    }
}
