package com.ovnisoft.baseapp.navigator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ovnisoft.baseapp.AndroidDependencyInjector;
import com.ovnisoft.navigator.BaseNavigator;
import com.ovnisoft.tracker.TrackerController;

public class BaseNavigatorImpl extends AppCompatActivity implements BaseNavigator {

    protected TrackerController mTrackerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTrackerController = AndroidDependencyInjector.getInstance().provideTrackerController();
    }

    /**
     * Replace a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment        The fragment to be added.
     */
    protected void replaceFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(containerViewId, fragment);
        fragmentTransaction.commit();
    }
}
