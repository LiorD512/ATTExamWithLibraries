package com.att.attexamwithlibraries.utils;

/**
 * Created by liord on 8/5/2018.
 */

public interface FragmentVisualizer {

    void showFragment(BaseFragment frag, boolean toBackStack, boolean clearAll);

    void removeAllFragments();
}
