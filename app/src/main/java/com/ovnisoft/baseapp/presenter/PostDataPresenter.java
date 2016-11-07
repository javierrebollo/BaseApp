package com.ovnisoft.baseapp.presenter;

import android.os.Handler;

import com.ovnisoft.baseapp.R;
import com.ovnisoft.baseapp.view.PostDataViewImpl;
import com.ovnisoft.data.callback.Callback;
import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.navigator.ExampleNavigator;
import com.ovnisoft.usesCase.SaveDataUseCase;

public class PostDataPresenter extends BasePresenter<PostDataViewImpl, ExampleNavigator> {

    private SaveDataUseCase mSaveDataUseCase;

    public PostDataPresenter(PostDataViewImpl view, ExampleNavigator navigator, SaveDataUseCase saveDataUseCase) {
        super(view, navigator);

        mSaveDataUseCase = saveDataUseCase;
    }

    public void saveData(String title, String body) {

        EntityExample entityExample = new EntityExample(title, body);

        mSaveDataUseCase.saveData(entityExample, new Callback<EntityExample>() {
            @Override
            public void onSuccess(EntityExample entityExample) {
                showMessage(R.string.data_saved);
            }

            @Override
            public void onError() {
                showMessage(R.string.fail_data_saved);
            }
        });
    }

    private void showMessage(final int textId) {
        Handler handler = new Handler(mView.getContext().getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                mView.showIfDataIsSaved(textId);
            }
        });
    }
}
