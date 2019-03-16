package com.att.attexamwithlibraries.utils;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.Objects;

/**
 * Created by liord on 8/5/2018.
 */

public abstract class BaseFragment extends Fragment implements FragmentVisualizer, OnBackPressedListener {

    public static final String TAG = BaseFragment.class.getSimpleName();


    public abstract String getManagerTag();

    public BaseFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            Objects.requireNonNull(getActivity()).onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setSupportActionBar(Toolbar toolbar) {
        final FragmentActivity activity = getActivity();
        if(activity instanceof AppCompatActivity) {
            ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        }
    }

    protected ActionBar getSupportActionBar() {
        final FragmentActivity activity = getActivity();
        if(activity instanceof AppCompatActivity) {
            return ((AppCompatActivity) activity).getSupportActionBar();
        }

        return null;
    }

    protected AppCompatActivity getCompatActivity() {
        final FragmentActivity activity = getActivity();
        if(activity instanceof AppCompatActivity) {
            return (AppCompatActivity) activity;
        }

        return null;
    }

    protected FragmentManager getSupportFragmentManager() {
        final FragmentActivity activity = getActivity();
        if(activity != null) {
            return activity.getSupportFragmentManager();
        }

        return null;
    }


    /**
     *
     * @param frag  Instance of Fragment to be shown.
     * @param toBackStack if this fragment should be added to back-stack.
     * @param clearAll If previous content of entry point should be removed (cleared is back-stack and current content).
     */
    @Override
    public void showFragment(BaseFragment frag, boolean toBackStack, boolean clearAll) {
        final Activity act = getActivity();
        if(act instanceof FragmentVisualizer) {
            ((FragmentVisualizer) act).showFragment(frag, toBackStack, clearAll);
        }
    }

    /**
     * Same as calling {@link BaseFragment#showFragment(BaseFragment, boolean, boolean)} with clearALL set to FALSE.
     * @param frag  Instance of Fragment to be shown.
     * @param toBackStack   if this fragment should be added to back-stack.
     */
    public void showFragment(BaseFragment frag, boolean toBackStack) {
        showFragment(frag, toBackStack, false);
    }

    @Override
    public void removeAllFragments() {
        final Activity act = getActivity();
        if(act instanceof FragmentVisualizer) {
            ((FragmentVisualizer) act).removeAllFragments();
        }
    }
}
