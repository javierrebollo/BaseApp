package com.ovnisoft.baseapp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ovnisoft.baseapp.AndroidDependencyInjector;
import com.ovnisoft.presenter.BasePresenter;
import com.ovnisoft.tracker.TrackerController;
import com.ovnisoft.view.BaseView;

public abstract class BaseViewImpl<P extends BasePresenter> extends Fragment implements BaseView {

    protected P mPresenter;
    protected TrackerController mTracker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mPresenter = getPresenter();
        mTracker = AndroidDependencyInjector.getInstance().provideTrackerController();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayout(), container, false);
        initComponent(view);
        setListeners();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /* Make whatever we want when the fragment is created */
    }

    /**
     * Get presenter
     *
     * @return {@link #mPresenter}
     */
    protected abstract P getPresenter();

    /**
     * Get fragment layout
     *
     * @return Layout id
     */
    protected abstract int getFragmentLayout();

    /**
     * Init all component of the class
     *
     * @param view Container view of the components
     */
    protected abstract void initComponent(View view);

    /**
     * Init all listeners
     */
    protected abstract void setListeners();
}
