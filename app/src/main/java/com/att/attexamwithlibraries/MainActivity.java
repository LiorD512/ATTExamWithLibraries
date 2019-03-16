package com.att.attexamwithlibraries;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.att.attexamwithlibraries.adapters.ContactListAdapter;
import com.att.attexamwithlibraries.interfaces.OnItemClickListener;
import com.att.attexamwithlibraries.model.Contact;
import com.att.attexamwithlibraries.model.ContactList;
import com.att.attexamwithlibraries.utils.BaseFragment;
import com.att.attexamwithlibraries.utils.FragmentVisualizer;
import com.att.attexamwithlibraries.view.contact.list.ContactListFragment;
import com.att.attexamwithlibraries.viewmodel.ContactListViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements FragmentVisualizer{

    private CentralFragmentVisualizer mCentralFragmentVisualizer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCentralFragmentVisualizer = new CentralFragmentVisualizer();

        if (getSupportFragmentManager().findFragmentById(R.id.main_container) == null) {
            showFragment(ContactListFragment.newInstance(), false, false);
        }


    }

    void clearBackStack() {
        final FragmentManager fm = getSupportFragmentManager();

        //noinspection StatementWithEmptyBody
        while (fm.popBackStackImmediate(R.id.main_container, FragmentManager.POP_BACK_STACK_INCLUSIVE)) {}

        if (fm.findFragmentById(R.id.main_container) != null) {
            getSupportFragmentManager().beginTransaction()
                    .remove(Objects.requireNonNull(fm.findFragmentById(R.id.main_container)))
                    .commitNow();
        }
    }

    @Override
    public void showFragment(BaseFragment frag, boolean toBackStack, boolean clearAll) {
        mCentralFragmentVisualizer.showFragment(frag, toBackStack, clearAll);
    }

    @Override
    public void removeAllFragments() {
        mCentralFragmentVisualizer.removeAllFragments();
    }


    class CentralFragmentVisualizer implements FragmentVisualizer {

        @Override
        public void showFragment(BaseFragment frag, boolean toBackStack, boolean clearAll) {
            final FragmentManager fm = getSupportFragmentManager();

            final BaseFragment currentFragment = (BaseFragment) fm.findFragmentById(R.id.main_container);
            if (currentFragment != null && frag.getManagerTag().equals(currentFragment.getManagerTag())) {
                return;
            }

            if (clearAll) {
                clearBackStack();
            }

            FragmentTransaction ft = fm.beginTransaction();
            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            if (fm.getBackStackEntryCount() > 0) {
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            }
            ft.replace(R.id.main_container, frag, frag.getManagerTag());
            if (toBackStack) {
                ft.addToBackStack(frag.getManagerTag());
            }

            ft.commit();

        }

        @Override
        public void removeAllFragments() {
            clearBackStack();
        }

        void afterOnBackPressed() {

        }
    }
}
